package CalcMov;

import java.text.DecimalFormat;

public class CalculodorMovilidadImp {


    public double descuentos(CalculadorMovilidad caloM){
        double[] descuentos={0,0.5,0.75,0.6,0.8};
        double desc=0;
        int tipoDesc= caloM.getColectivo()-1;
        for (int i=0; i<=descuentos.length;i++){
            if(tipoDesc==i){
                desc=descuentos[i];
            }
        }
        return desc;
    }

    public double pagoPorBillete(CalculadorMovilidad CM){
        double des;
        double viaje =2.75;
        double porBillete;
        double precio;
        CalculodorMovilidadImp prueba = new CalculodorMovilidadImp();
        des=prueba.descuentos(CM);


        if (des>0){
            precio=viaje;
            porBillete=precio-(precio*des);
        }else {
            porBillete=viaje;
        }
        return porBillete;
    }

    public double precioIlimitado7d(CalculadorMovilidad CM){

        double des;
        double viaje =33;
        double ilim7=0;
        double precio;
        CalculodorMovilidadImp prueba = new CalculodorMovilidadImp();
        des=prueba.descuentos(CM);

        if (des>0) {
            ilim7 = viaje;

              if (CM.getDiasEstimados() % 7.0 == 0) {
                  precio=CM.getDiasEstimados() / 7.0 * viaje;
                  ilim7 = precio-(precio* des);

              } else if (CM.getDiasEstimados() % 7 >0) {
                   precio=  Math.ceil(CM.getDiasEstimados() / 7.0)*viaje;
                  ilim7 = precio-(precio* des) ;
              }
              }
        else {
            if (CM.getDiasEstimados() % 7 == 0) {
                ilim7 = CM.getDiasEstimados() / 7.0 * viaje;

            } else if (CM.getDiasEstimados() % 7 >0) {

                ilim7 = Math.ceil(CM.getDiasEstimados() / 7.0) * viaje;
          }
        }
        ilim7=ilim7/CM.getViajesPrevistos();
        return ilim7;
    }


    public double precioIlimitado30d(CalculadorMovilidad CM){
        double des;
        double viaje =127;
        double ilim30=0;
        double precio;
        CalculodorMovilidadImp prueba = new CalculodorMovilidadImp();
        des=prueba.descuentos(CM);

        if (des>0) {
            ilim30 = viaje;

                if (CM.getDiasEstimados() % 30 == 0) {
                    precio=CM.getDiasEstimados()/30.0 * viaje;
                    ilim30 =  precio-(precio* des);

                } else if (CM.getDiasEstimados() % 30 >0) {
                        precio=(Math.ceil(CM.getDiasEstimados() / 30.0)) * viaje;
                    ilim30 =  precio-(precio* des);

                }
        }else {
            if (CM.getDiasEstimados() % 30 == 0) {
                ilim30 = CM.getDiasEstimados() / 30.0 * viaje;

            } else if (CM.getDiasEstimados() % 30 >0) {
                double dias=CM.getDiasEstimados();

                ilim30 = Math.ceil(dias/30) * viaje;

            }
        }
        ilim30=ilim30/CM.getViajesPrevistos();
        return ilim30;
    }

    public String mejorOpciontext(double[] menor, int elecColec){

        DecimalFormat formato1 = new DecimalFormat("0.00");
        String texto;
        String colectivo="";

               int posicion=(int)menor[1];

            if (elecColec==1){
                colectivo="(Sin descuento)";
            }else if(elecColec==2){
                colectivo="(Jubilado)";
            }else if(elecColec==3) {
                colectivo = "(Discapacitado)";
            }else if(elecColec==4){
                colectivo="(Parado)";
            }else if(elecColec==5){
                colectivo="(Estudiante)";
            }

            if (posicion==0){
                texto= (colectivo +"\n Debería coger la \n opción de \n Billete Suelto: " +formato1.format(menor[0])+"€ por viaje" );
            }else if (posicion==1){
                texto=(colectivo +"\n Debería coger la \n Opción de\n Bono para 7 días " +formato1.format(menor[0])+"€ por viaje" );
            }else{texto=(colectivo +"\n Debería coger la \n Opción de \n Bono para 30 días " +formato1.format(menor[0])+"€ por viaje" );
            }
        return texto;
        }



    public double[] mejorOpcion(double b, double b7, double b30){
        //calculamos la mejor opcion y devolvemos la posicion de la tabla para elegir luego el texto
        double[] tablaUsu =new double[3];
        double[] menor={0,0};
        tablaUsu[0]=b;
        tablaUsu[1]=b7;
        tablaUsu[2]=b30;

        menor[0]=tablaUsu[0];

        for (int i=0; i<tablaUsu.length;i++ ){
            if(menor[0]>tablaUsu[i]){
                menor[0]=tablaUsu[i];
                menor[1]=i;
            }

        }
        return menor;
    }

    public int imagenMostrar(CalculadorMovilidad CM,double menor){
        int img=0;
        double[] tablaOp = new double[15];

        CalculodorMovilidadImp cmi =new CalculodorMovilidadImp();

            for (int i = 1; i <=5; i++) {
                CM.setColectivo(i);
                cmi.pagoPorBillete(CM);
                tablaOp[i-1]=cmi.pagoPorBillete(CM);
            }

            for (int i = 1; i <=5; i++) {
                CM.setColectivo(i);
                cmi.precioIlimitado7d(CM);
                tablaOp[i+4]= cmi.precioIlimitado7d(CM);
            }
            for (int i = 1; i <=5; i++) {
                CM.setColectivo(i);
                cmi.precioIlimitado30d(CM);
                tablaOp[i+9]= cmi.precioIlimitado30d(CM);
            }




        for (int i=0; i<tablaOp.length;i++){
            if (menor==tablaOp[i]){
                img=i;
            }
        }

      return img;
    }

}
