# Medidor de Cores

Biblioteca Java que gera uma cor para ser usada em um gauge (medidor), muito usado em sistemas que monitoram algum tipo de nível de serviço, tempo, etc.

Este medidor vai do verde ao vermelho, de acordo com o nível máximo.

A classe ColorGauge recebe o nivel máximo no seu construtor e tem um método público chamado getColor que recebe a posição atual  e retorna uma string de cor no formato RGB. Por exemplo, para a cor amarela, que corresponde à metade do nível máximo o código seri: 'rgb(255,255,0)'.

