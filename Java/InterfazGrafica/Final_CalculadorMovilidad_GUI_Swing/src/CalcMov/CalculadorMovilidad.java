package CalcMov;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.DefaultFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.ImageIcon;



public class CalculadorMovilidad  {
    int colectivo;
    int diasEstimados;
    int viajesPrevistos;


    public CalculadorMovilidad(int colectivo, int diasEstimados,int viajesPrevistos){

      this.colectivo=colectivo;
      this.diasEstimados=diasEstimados;
      this.viajesPrevistos=viajesPrevistos;

    }




        //Coge las imágenes y las coloca en una tabla de tipo ImageIcon.


    public int getColectivo() {
        return colectivo;
    }

    public int getDiasEstimados() {
        return diasEstimados;
    }

    public int getViajesPrevistos() {
        return viajesPrevistos;
    }

    public void setColectivo(int colectivo) {
        this.colectivo = colectivo;
    }


    public static void main (String[]args){

        int colec = 0;
        int diasE = 0;
        int viaPre = 0;



        CalculadorMovilidad cm=new CalculadorMovilidad(colec,diasE,viaPre);
        CalculodorMovilidadImp cmv=new CalculodorMovilidadImp();

            JFrame marco = new JFrame(" Aplicación Movilidad");
            SpinnerNumberModel model = new SpinnerNumberModel(
                    Integer.valueOf(1), // Dato visualizado al inicio en el spinner
                    Integer.valueOf(1), // Límite inferior
                    Integer.valueOf(200), // Límite superior
                    Integer.valueOf(1) // incremento-decremento
        );

            final JSpinner spinner = new JSpinner(model);

            spinner.setPreferredSize(new Dimension(50,20));
            JComponent comp = spinner.getEditor();
            JFormattedTextField field = (JFormattedTextField) comp.getComponent(0);
            DefaultFormatter formatter = (DefaultFormatter) field.getFormatter();
            formatter.setCommitsOnValidEdit(true);


            JLabel dia=new JLabel("Dias");
            JLabel imagen=new JLabel();

            JTextArea propuesta=new JTextArea();
            propuesta.setOpaque(false);
            propuesta.setPreferredSize(new Dimension(185,70));
            propuesta.setLineWrap(true);
            propuesta.setEditable(false);

            JPanel panel = new JPanel();
            JPanel panel2 = new JPanel();
            panel2.setLayout(new GridLayout(5,1,5,5));
            JPanel panel3 = new JPanel();
            JPanel panel4 = new JPanel();

            JPanel panel5 = new JPanel();
            JPanel panel6 = new JPanel();
            ImageIcon valiboton= new ImageIcon("src/images/valBot.png");
            JButton confirma=new JButton(valiboton);
            ImageIcon canBoton= new ImageIcon("src/images/canBot.png");
            JButton cancela=new JButton(canBoton);
            marco.setLayout(new GridLayout(2, 2, 10, 10));

//////////////slider
            JLabel etiqueta = new JLabel();
            JSlider slider = new JSlider(1, 100, 1);
            slider.setPaintTrack(true);
            slider.setPaintTicks(true);
            slider.setPaintLabels(true);
            slider.setMajorTickSpacing(20);
            slider.setMinorTickSpacing(5);


            ///////////radio boton
            JRadioButton botRadio1 = new JRadioButton();
            JRadioButton botRadio2= new JRadioButton();
            JRadioButton botRadio3= new JRadioButton();
            JRadioButton botRadio4= new JRadioButton();
            JRadioButton botRadio5= new JRadioButton();

            botRadio1.setText("Sin descuento");
            botRadio2.setText("Jubilado");
            botRadio3.setText("Discapacitado");
            botRadio4.setText("Parado");
            botRadio5.setText("Estudiante");
            ButtonGroup agrupBotRad = new ButtonGroup();

            agrupBotRad.add(botRadio1);
            agrupBotRad.add(botRadio2);
            agrupBotRad.add(botRadio3);
            agrupBotRad.add(botRadio4);
            agrupBotRad.add(botRadio5);
            botRadio1.doClick();
            cm.diasEstimados=1;
            cm.colectivo=1;
            cm.viajesPrevistos=1;





/////////////


////añadir los paneles
            panel.add(dia);
            panel.add(spinner);
            panel.add(slider);//añadido slider
            panel.add(etiqueta);//etiqueta slider
            panel2.add(botRadio1);
            panel2.add(botRadio2);
            panel2.add(botRadio3);
            panel2.add(botRadio4);
            panel2.add(botRadio5);
            panel3.add(panel5);
            panel3.add(panel6);
            panel5.add(propuesta);
            panel6.add(confirma);
            panel6.add(cancela);
            panel4.add(imagen);


            marco.add(panel);
            panel.setBorder(BorderFactory.createCompoundBorder(BorderFactory
                    .createTitledBorder("Estancia"), BorderFactory
                    .createEmptyBorder(5, 5, 5, 5)));
            panel2.setBorder(BorderFactory.createCompoundBorder(BorderFactory
                    .createTitledBorder("Colectivo"), BorderFactory
                    .createEmptyBorder(5, 5, 5, 5)));

            panel3.setBorder(BorderFactory.createCompoundBorder(BorderFactory
                    .createTitledBorder("Propuesta"), BorderFactory
                    .createEmptyBorder(5, 5, 5, 5)));
            panel4.setBorder(BorderFactory.createCompoundBorder(BorderFactory
                    .createTitledBorder("Su billete"), BorderFactory
                    .createEmptyBorder(5, 5, 5, 5)));
            panel5.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLoweredBevelBorder(), BorderFactory
                            .createEmptyBorder(5, 5, 5, 5)));





            marco.add(panel2);
            marco.add(panel3);
            marco.add(panel4);
            panel4.add(imagen);

            //Para colocar texto inicial con el valor del JSlider
            etiqueta.setText("Viajes = "+slider.getValue());

            marco.setSize(510,500);
            marco.setVisible(true);

//////////////////////botones de escucha
        slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent event) {
                cm.viajesPrevistos=slider.getValue();
                etiqueta.setText("Viajes = " + slider.getValue());
            }
        });

            spinner.addChangeListener(new ChangeListener() {

                public void stateChanged(ChangeEvent e) {
                    cm.diasEstimados= (Integer) spinner.getValue();

                }
            });



            ActionListener actionListener = new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    double[] tabOP;

                    cmv.pagoPorBillete(cm);
                    cmv.precioIlimitado7d(cm);
                    cmv.precioIlimitado30d(cm);
                    int elecColec=cm.getColectivo();

                    tabOP=cmv.mejorOpcion(cmv.pagoPorBillete(cm),cmv.precioIlimitado7d(cm),cmv.precioIlimitado30d(cm));

                    String texto=cmv.mejorOpciontext(tabOP,elecColec);
                   propuesta.setText(texto);

                    imagen.setIcon(new ImageIcon("src/images/imagen"+cmv.imagenMostrar(cm,tabOP[0])+ ".jpg"));
                    imagen.setPreferredSize(new Dimension(230,150));
                    imagen.setHorizontalAlignment(JLabel.CENTER);
                    imagen.setVerticalAlignment(JLabel.CENTER);


                }
            };
            confirma.addActionListener(actionListener);

        cancela.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            slider.setValue(1);
            spinner.setValue(1);
            botRadio1.doClick();
            imagen.setIcon(null);
            propuesta.setText(null);
            }
        });
        ////////tenemos que tener esto separado ya que si no no reconoce bien los radiobuttons
        ///////por ello tenemos que hacer que se confrimen despues.
        confirma.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (botRadio1.isSelected()) {
                    cm.colectivo= 1;
                } else if (botRadio2.isSelected()==true) {
                    cm.colectivo = 2;
                } else if (botRadio3.isSelected()==true) {
                    cm.colectivo = 3;
                } else if (botRadio4.isSelected()==true) {
                    cm.colectivo=4;
                } else if (botRadio5.isSelected()==true) {
                    cm.colectivo=5;
                }else{
                    imagen.setIcon(null);
                    propuesta.setText(null);
                }

            }
        });


        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setResizable(false);

    }

}
