#include <stdio.h> 
#include "pvm3.h" 
#include <stdlib.h> 
#include <string.h> 

main()
{
	int i, parent_tid = pvm_parent();
	int num;
	int cub = 0;
	int mytid = pvm_mytid();

	//SE RECIBEN LOS DATOS DEL MAESTRO
	pvm_recv(parent_tid, 1); //recibo con etiqueta 1 
	pvm_upkint(&num, 1, 1); //Recibe elemento en terminal 1

	cub = num * num * num;

	printf("\tESCLAVO t%x Cubo = %d ", mytid, cub);

	//SE ENVIA EL RESULTADO AL MAESTRO
	pvm_initsend(PvmDataDefault); 
	pvm_pkint(&cub, 1, 1); // Envía un elemento al temrinal 1)
	pvm_send(parent_tid, 2); //envio con etiqueta 2

	pvm_exit(); 
	exit(0);
}
