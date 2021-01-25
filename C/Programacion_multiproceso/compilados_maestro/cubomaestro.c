#include <stdio.h> 
#include "pvm3.h" 
#include <stdlib.h> 
#include <string.h> 

main()
{
	int tareas, cc, tid; 
	int etqenvio=1; 
	int etqrecibe=2;
	int num = 3;

	tareas = pvm_spawn("cuboesclavo", (char**)0, 0, "", 1, &tid);

	//ENVIO NÚMERO
	pvm_initsend(PvmDataDefault); //Limpia el buffer antes de enviar paquete.
	pvm_pkint(&num, 1, 1); //Envía un elemento al terminal 1
	pvm_send(tid, etqenvio); //envio con etiq 1 

	printf("\tENVÍO A t%x: %d\n", tid, num);

	//RECIBO NÚMERO
	cc = pvm_recv(tid, etqrecibe); //recibo con etiq 2 
	pvm_upkint(&num, 1, 1); //desempaqueta un entero 
	printf("\tRECIBO DE t%x: %d\n", tid, num);

	pvm_exit(); 
	exit(0);
}
