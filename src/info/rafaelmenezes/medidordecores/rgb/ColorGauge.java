package info.rafaelmenezes.medidordecores.rgb;

/**
 * @author Rafael Menezes (rafael.87@gmail.com)
 * @date 2016/05/14
 */
public class ColorGauge {

	private Integer posicaoDoCursor;
	private double quantidadeVermelho;
	private double quantidadeVerde;
	private Integer maiorPosicaoPossivel;

	public ColorGauge(Integer maiorPosicaoPossivel) {
		super();
		this.maiorPosicaoPossivel = maiorPosicaoPossivel;
	}

	// Testa se o cursor (nivel passado) está na primeira metade do marcador
	private boolean cursorNaPrimeiraMetade() {
		return (posicaoDoCursor > 0 && posicaoDoCursor <= 50);
	}

	// Testa se o cursor (nivel passado) está na segunda metade do marcador
	private boolean cursorNaSegundaMetade() {
		return (posicaoDoCursor > 50 && posicaoDoCursor <= 100);
	}

	public String getColor(Integer posicaoAtual) {
		if (posicaoAtual > this.maiorPosicaoPossivel) {
			System.out.println("Posição atual ultrapassa os limites. Trabalhando com a maior posição possível");
			posicaoAtual = this.maiorPosicaoPossivel;
		}
		// Trabalhando com 50 posições na primeira metade e 50 na segunda (base
		// 100).
		this.posicaoDoCursor = (posicaoAtual * 100) / this.maiorPosicaoPossivel;
		// 50 * 5.1 = 255
		double step = 5.1;
		// Caso esteja na primeira metade devo aumentar o nível de vermelho
		if (cursorNaPrimeiraMetade()) {
			quantidadeVermelho = 0.;
			quantidadeVerde = 255.;
			quantidadeVermelho = posicaoDoCursor * step;
		}
		// Caso esteja na primeira metade devo diminuir o nível de verde
		if (cursorNaSegundaMetade()) {
			quantidadeVermelho = 255.;
			quantidadeVerde = 255.;
			double diminuirDoVerde = (posicaoDoCursor - 50.) * step;
			quantidadeVerde = quantidadeVerde - diminuirDoVerde;
		}

		// Retorna o código RGB -
		return codigoRgbGerado();
	}

	// Método responsável por calcular e retornar a string da cor
	// Exemplo: cor amarela -> 'rgb(255,255,0)'
	private String codigoRgbGerado() {
		Long inter = new Long(0);
		inter = Math.round(quantidadeVermelho);
		Integer red = inter.intValue();
		inter = new Long(0);
		inter = Math.round(quantidadeVerde);
		Integer green = inter.intValue();
		String result = "rgb(" + red + "," + green + ", 0)";
		// System.out.println(result);
		return result;
	}

}
