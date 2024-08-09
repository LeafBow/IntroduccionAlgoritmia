Algoritmo Saldo
	//Declarar variables
	Definir propsem, gpsj, gcom, ggus, ahorro, gastos Como real
	
	//Ingreso de datos
	Escribir "Ingrese propina"
	Leer propsem
	Escribir "Ingrese pasajes"
	Leer gpsj
	Escribir "Ingrese comida"
	Leer gcom
	Escribir "Ingrese gustitos"
	Leer ggus
	
	//Proceso 
	gastos = gpsj + gcom + ggus
	ahorro = propsem - gastos
	
	//Salida de datos
	Escribir  "Mi ahorro es:" + ConvertirATexto(ahorro)
	
FinAlgoritmo
