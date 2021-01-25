package Puntuable3;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class Peliculas {
    Scanner teclado = new Scanner(System.in);
    int opcion;

    public void opciones() {
        System.out.println("\n\t\t\tPelículas\n\t\t\t=========\n");
        System.out.println("1. Presentar el documento XML completo.");
        System.out.println("2. Añadir nuevo nodo al documento.");
        System.out.println("3. Modificar datos de un nodo del documento.");
        System.out.println("4. Eliminar un nodo concreto del documento.");
        System.out.println("5. Salir.\n");
    }

    public void presentar() {
        //Creamos una referencia (fichXML) de tipo File al cargar el fichero XML existente
        File fichXML = new File("src/peliculas.xml");
        try {
            Document doc = perseoEliminavacios(fichXML);
            //Vuelca a una lista los nodos película que cuelgan del nodo raíz películas
            NodeList peli = doc.getElementsByTagName("pelicula");
            for (int cont = 0; cont < peli.getLength(); cont++) {
                //Se recorre la lista con nodos y se extrae en nodo el que indica cont
                Node nodo = peli.item(cont);
                //Para saber qué nodo está procesando, imprime el nombre
                System.out.println("------------------------");
                System.out.println(nodo.getNodeName() + " --> Nodo: " + cont);
                //Comprueba si se encuentra ante un elemento
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    //Castea el nodo de tipo Node a un tipo Element
                    Element element = (Element) nodo;
                    System.out.println("Título: " + element.getElementsByTagName("titulo").item(0).getTextContent());
                    System.out.println("Guionista: " + element.getElementsByTagName("guionista").item(0).getTextContent());
                    System.out.println("Productora: " + element.getElementsByTagName("productora").item(0).getTextContent());
                    System.out.println("Director: " + element.getElementsByTagName("director").item(0).getTextContent());
                    System.out.println("Actor: " + element.getElementsByTagName("actor").item(0).getTextContent());
                    System.out.println("Sinopsis: " + element.getElementsByTagName("sinopsis").item(0).getTextContent());
                }
            }
            System.out.println("------------------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void anadirnodo() {
        String tit, gui, pro, dir, act, sin;
        System.out.println("1. Ubicación del nodo al principio.");
        System.out.println("2. Ubicación del nodo  al final.");
        System.out.println("3. Ubicación del nodo intermedia.");
        //Creamos una referencia (fichXML) de tipo File al cargar el fichero XML existente
        File fichXML = new File("src/peliculas.xml");
        System.out.println("\nElige una opción: ");
        opcion = teclado.nextInt();
        teclado.nextLine();
        switch (opcion) {
            case 1:
                try {
                    //Parsea el fichero y lo convierte de fichero a documento XML recorrible
                    Document doc = perseoEliminavacios(fichXML);
                    //Localizamos el elemento raíz
                    Element raiz = doc.getDocumentElement();
                    // Crea el elemento Pelicula y lo asigna como nodo al elemento raíz
                    NodeList peli = doc.getElementsByTagName("pelicula");
                    Element Pelicula = doc.createElement("pelicula");
                    raiz.insertBefore( Pelicula, peli.item(0) );
                    creandoElementos(doc, Pelicula);
                    // Prepara el contenido generado en formato DOM
                    domcompatiblexml(doc);
                } catch(Exception e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                try {
                    //Parsea el fichero y lo convierte de fichero a documento XML recorrible
                    Document doc = perseoEliminavacios(fichXML);
                    //Localizamos el elemento raíz
                    Element raiz = doc.getDocumentElement();
                    // Crea el elemento Pelicula y lo asigna como nodo al elemento raíz
                    Element Pelicula = doc.createElement("pelicula");
                    raiz.appendChild(Pelicula);
                    creandoElementos(doc, Pelicula);
                    // Prepara el contenido generado en formato DOM
                    domcompatiblexml(doc);
                } catch(Exception e) {
                    e.printStackTrace();
                }
                break;
            case 3:
                try {
                    //Parsea el fichero y lo convierte de fichero a documento XML recorrible
                    Document doc = perseoEliminavacios(fichXML);
                    //Localizamos el elemento raíz
                    Element raiz = doc.getDocumentElement();
                    // Crea el elemento Pelicula y lo asigna como nodo al elemento raíz
                    NodeList peli = doc.getElementsByTagName("pelicula");
                    Element Pelicula = doc.createElement("pelicula");
                    raiz.insertBefore( Pelicula, peli.item(2) );
                    creandoElementos(doc, Pelicula);
                    domcompatiblexml(doc);

                } catch(Exception e) {
                    e.printStackTrace();
                }
                break;
        }
    }
    public void modificarnodo(){
        String tit, gui, pro, dir, act, sin;
        System.out.println("1. Modificación de nodo ubicado al principio.");
        System.out.println("2. Modificación de nodo ubicado al final.");
        System.out.println("3. Modificación de nodo intermedio.");
        //Creamos una referencia (fichXML) de tipo File al cargar el fichero XML existente
        File fichXML = new File("src/peliculas.xml");
        System.out.println("\nElige una opción: ");
        opcion = teclado.nextInt();
        teclado.nextLine();
        switch (opcion) {
            case 1:
                try {
                    //Parsea el fichero y lo convierte de fichero a documento XML recorrible
                    Document doc = perseoEliminavacios(fichXML);
                    //Encaja el nodo raíz del documento (películas)
                    Node raizpeliculas = doc.getFirstChild();
                    //Vuelca a una lista los nodos que cuelgan del nodo raíz (película)
                    NodeList npelicula = raizpeliculas.getChildNodes();
                    //Se va al primer nodo
                    Node principio = npelicula.item(0);
                    //Vuelca a una lista los nodos que cuelgan del nodo pelicula (titulo...)
                    NodeList nprimernodo = principio.getChildNodes();
                    //Pide datos por teclado
                    System.out.println("Indica el nuevo título: ");
                    tit = teclado.nextLine();
                    System.out.println("Indica el nuevo guionista: ");
                    gui = teclado.nextLine();
                    System.out.println("Indica la nueva productora: ");
                    pro = teclado.nextLine();
                    System.out.println("Indica el nuevo director: ");
                    dir = teclado.nextLine();
                    System.out.println("Indica el nuevo actor: ");
                    act = teclado.nextLine();
                    System.out.println("Indica la nueva sinopsis: ");
                    sin = teclado.nextLine();
                    for (int cont2N = 0; cont2N < nprimernodo.getLength(); cont2N++) {
                        //De la lista de pelicula, encajar uno a uno en forma de nodo
                        Node cadaItem= nprimernodo.item(cont2N);
                        //Detecta si los elementos son titulo...
                        if ("titulo".equals(cadaItem.getNodeName())) {
                            // Modifica todos los nodos denominacion del documento
                            cadaItem.setTextContent(tit);
                        }
                        if ("guionista".equals(cadaItem.getNodeName())) {
                            // Modifica todos los nodos denominacion del documento
                            cadaItem.setTextContent(gui);
                        }
                        if ("productora".equals(cadaItem.getNodeName())) {
                            // Modifica todos los nodos denominacion del documento
                            cadaItem.setTextContent(pro);
                        }
                        if ("director".equals(cadaItem.getNodeName())) {
                            // Modifica todos los nodos denominacion del documento
                            cadaItem.setTextContent(dir);
                        }
                        if ("actor".equals(cadaItem.getNodeName())) {
                            // Modifica todos los nodos denominacion del documento
                            cadaItem.setTextContent(act);
                        }
                        if ("sinopsis".equals(cadaItem.getNodeName())) {
                            // Modifica todos los nodos denominacion del documento
                            cadaItem.setTextContent(sin);
                        }
                    }
                    transformadorModificar(doc);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                try {
                    //Parsea el fichero y lo convierte de fichero a documento XML recorrible
                    Document doc = perseoEliminavacios(fichXML);
                    //Encaja el nodo raíz del documento (películas)
                    Node raizpeliculas = doc.getFirstChild();
                    //Vuelca a una lista los nodos que cuelgan del nodo raíz (pelicula)
                    NodeList npelicula = raizpeliculas.getChildNodes();
                    //Se va al último nodo
                    Node fin = npelicula.item((npelicula.getLength()-1));
                    //Vuelca a una lista los nodos que cuelgan del nodo pelicula (título...)
                    NodeList nprimernodo = fin.getChildNodes();
                    //Pide datos por teclado
                    System.out.println("Indica el nuevo título: ");
                    tit = teclado.nextLine();
                    System.out.println("Indica el nuevo guionista: ");
                    gui = teclado.nextLine();
                    System.out.println("Indica la nueva productora: ");
                    pro = teclado.nextLine();
                    System.out.println("Indica el nuevo director: ");
                    dir = teclado.nextLine();
                    System.out.println("Indica el nuevo actor: ");
                    act = teclado.nextLine();
                    System.out.println("Indica la nueva sinopsis: ");
                    sin = teclado.nextLine();
                    for (int cont2N = 0; cont2N < nprimernodo.getLength(); cont2N++) {
                        //De la lista de pelicula, encajar uno a uno en forma de nodo
                        Node cadaItem= nprimernodo.item(cont2N);
                        //Detecta si los elementos son título...
                        if ("titulo".equals(cadaItem.getNodeName())) {
                            // Modifica todos los nodos denominacion del documento
                            cadaItem.setTextContent(tit);
                        }
                        if ("guionista".equals(cadaItem.getNodeName())) {
                            // Modifica todos los nodos denominacion del documento
                            cadaItem.setTextContent(gui);
                        }
                        if ("productora".equals(cadaItem.getNodeName())) {
                            // Modifica todos los nodos denominacion del documento
                            cadaItem.setTextContent(pro);
                        }
                        if ("director".equals(cadaItem.getNodeName())) {
                            // Modifica todos los nodos denominacion del documento
                            cadaItem.setTextContent(dir);
                        }
                        if ("actor".equals(cadaItem.getNodeName())) {
                            // Modifica todos los nodos denominacion del documento
                            cadaItem.setTextContent(act);
                        }
                        if ("sinopsis".equals(cadaItem.getNodeName())) {
                            // Modifica todos los nodos denominacion del documento
                            cadaItem.setTextContent(sin);
                        }
                    }
                    //Prepara el documento XML resultante para mostrarlo por pantalla y grabarlo
                    transformadorEliminar(doc);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 3:
                try {
                    //Parsea el fichero y lo convierte de fichero a documento XML recorrible
                    Document doc = perseoEliminavacios(fichXML);
                    //Encaja el nodo raíz del documento (películas)
                    Node raizpeliculas = doc.getFirstChild();
                    //Vuelca a una lista los nodos que cuelgan del nodo raíz (película)
                    NodeList npelicula = raizpeliculas.getChildNodes();
                    //Se va al nodo 1 (intermedio)
                    Node intermedio = npelicula.item(1);
                    //Vuelca a una lista los nodos que cuelgan del nodo pelicula (título)
                    NodeList nprimernodo = intermedio.getChildNodes();
                    //Pide datos por teclado
                    System.out.println("Indica el nuevo título: ");
                    tit = teclado.nextLine();
                    System.out.println("Indica el nuevo guionista: ");
                    gui = teclado.nextLine();
                    System.out.println("Indica la nueva productora: ");
                    pro = teclado.nextLine();
                    System.out.println("Indica el nuevo director: ");
                    dir = teclado.nextLine();
                    System.out.println("Indica el nuevo actor: ");
                    act = teclado.nextLine();
                    System.out.println("Indica la nueva sinopsis: ");
                    sin = teclado.nextLine();
                    for (int cont2N = 0; cont2N < nprimernodo.getLength(); cont2N++) {
                        //De la lista de pelicula, encajar uno a uno en forma de nodo
                        Node cadaItem= nprimernodo.item(cont2N);
                        //Detecta si los elementos son título...
                        if ("titulo".equals(cadaItem.getNodeName())) {
                            // Modifica todos los nodos denominacion del documento
                            cadaItem.setTextContent(tit);
                        }
                        if ("guionista".equals(cadaItem.getNodeName())) {
                            // Modifica todos los nodos denominacion del documento
                            cadaItem.setTextContent(gui);
                        }
                        if ("productora".equals(cadaItem.getNodeName())) {
                            // Modifica todos los nodos denominacion del documento
                            cadaItem.setTextContent(pro);
                        }
                        if ("director".equals(cadaItem.getNodeName())) {
                            // Modifica todos los nodos denominacion del documento
                            cadaItem.setTextContent(dir);
                        }
                        if ("actor".equals(cadaItem.getNodeName())) {
                            // Modifica todos los nodos denominacion del documento
                            cadaItem.setTextContent(act);
                        }
                        if ("sinopsis".equals(cadaItem.getNodeName())) {
                            // Modifica todos los nodos denominacion del documento
                            cadaItem.setTextContent(sin);
                        }
                    }
                    //Prepara el documento XML resultante para mostrarlo por pantalla y grabarlo
                    transformadorModificar(doc);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
    }
    public void eliminarnodo(){
        System.out.println("1. Eliminación de nodo ubicado al principio.");
        System.out.println("2. Eliminación de nodo ubicado al final.");
        System.out.println("3. Eliminación de nodo intermedio.");
        //Creamos una referencia (fichXML) de tipo File al cargar el fichero XML existente
        File fichXML = new File("src/peliculas.xml");
        System.out.println("\nElige una opción: ");
        opcion = teclado.nextInt();
        teclado.nextLine();
        switch (opcion){
            case 1:
                try{
                    //Parsea el fichero y lo convierte de fichero a documento XML recorrible
                    Document doc = perseoEliminavacios(fichXML);
                    //Encaja el nodo raíz del documento (películas)
                    Node raizpeliculas = doc.getFirstChild();
                    //Vuelca a una lista los nodos que cuelgan del nodo raíz (película)
                    NodeList npelicula = raizpeliculas.getChildNodes();
                    //Se va al primer nodo
                    Node principio = npelicula.item(0);
                    if ("pelicula".equals(principio.getNodeName())) {
                        //Borra el nodo
                        principio.getParentNode().removeChild(principio);
                    }
                    //Prepara el documento XML resultante para mostrarlo por pantalla y grabarlo
                    transformadorEliminar(doc);
                } catch (ParserConfigurationException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (SAXException e) {
                    e.printStackTrace();
                } catch (TransformerConfigurationException e) {
                    e.printStackTrace();
                } catch (TransformerException e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                try{
                    //Parsea el fichero y lo convierte de fichero a documento XML recorrible
                    Document doc = perseoEliminavacios(fichXML);
                    //Encaja el nodo raíz del documento (películas)
                    Node raizpeliculas = doc.getFirstChild();
                    //Vuelca a una lista los nodos que cuelgan del nodo raíz (película)
                    NodeList npelicula = raizpeliculas.getChildNodes();
                    //Se va al último nodo
                    Node ultimo = npelicula.item((npelicula.getLength()-1));
                    if ("pelicula".equals(ultimo.getNodeName())) {
                        //Borra el nodo
                        ultimo.getParentNode().removeChild(ultimo);
                    }
                    //Prepara el documento XML resultante para mostrarlo por pantalla y grabarlo
                    transformadorEliminar(doc);
                } catch (ParserConfigurationException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (SAXException e) {
                    e.printStackTrace();
                } catch (TransformerConfigurationException e) {
                    e.printStackTrace();
                } catch (TransformerException e) {
                    e.printStackTrace();
                }
                break;
            case 3:
                try{
                    //Parsea el fichero y lo convierte de fichero a documento XML recorrible
                    Document doc = perseoEliminavacios(fichXML);
                    //Encaja el nodo raíz del documento (películas)
                    Node raizpeliculas = doc.getFirstChild();
                    //Vuelca a una lista los nodos que cuelgan del nodo raíz (película)
                    NodeList npelicula = raizpeliculas.getChildNodes();
                    //Se va al nodo 1 (intermedio)
                    Node intermedia = npelicula.item(1);
                    if ("pelicula".equals(intermedia.getNodeName())) {
                        //Borra el nodo
                        intermedia.getParentNode().removeChild(intermedia);
                    }
                    transformadorEliminar(doc);
                } catch (ParserConfigurationException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (SAXException e) {
                    e.printStackTrace();
                } catch (TransformerConfigurationException e) {
                    e.printStackTrace();
                } catch (TransformerException e) {
                    e.printStackTrace();
                }
                break;
        }
    }
    private Document perseoEliminavacios(File fichXML) throws ParserConfigurationException, SAXException, IOException {
        //Parsea el fichero y lo convierte de fichero a documento XML recorrible
        DocumentBuilderFactory factoriaDoc = DocumentBuilderFactory.newInstance();
        DocumentBuilder constructDoc = factoriaDoc.newDocumentBuilder();
        Document doc = constructDoc.parse(fichXML);
        //Elimina nodos vacíos y combina adyacentes en caso de que los hubiera
        doc.getDocumentElement().normalize();
        return doc;
    }
    private void creandoElementos(Document doc, Element pelicula) {
        String tit;
        String gui;
        String pro;
        String dir;
        String act;
        String sin;
        // Crea elementos, les da valor y los asigna como nodos al elemento Pelicula
        System.out.println("Indica el título de la película: ");
        tit = teclado.nextLine();
        Element Titulo = doc.createElement("titulo");
        Titulo.appendChild(doc.createTextNode(tit));
        pelicula.appendChild(Titulo);
        System.out.println("Indica el guionista de la película: ");
        gui = teclado.nextLine();
        Element Guionista = doc.createElement("guionista");
        Guionista.appendChild(doc.createTextNode(gui));
        pelicula.appendChild(Guionista);
        System.out.println("Indica la productora de la película: ");
        pro = teclado.nextLine();
        Element Productora = doc.createElement("productora");
        Productora.appendChild(doc.createTextNode(pro));
        pelicula.appendChild(Productora);
        System.out.println("Indica el director de la película: ");
        dir = teclado.nextLine();
        Element Director = doc.createElement("director");
        Director.appendChild(doc.createTextNode(dir));
        pelicula.appendChild(Director);
        System.out.println("Indica el actor de la película: ");
        act = teclado.nextLine();
        Element Actor = doc.createElement("actor");
        Actor.appendChild(doc.createTextNode(act));
        pelicula.appendChild(Actor);
        System.out.println("Indica la sinopsis de la película: ");
        sin = teclado.nextLine();
        Element Sinopsis = doc.createElement("sinopsis");
        Sinopsis.appendChild(doc.createTextNode(sin));
        pelicula.appendChild(Sinopsis);
    }
    private void domcompatiblexml(Document doc) throws TransformerException {
        // Prepara el contenido generado en formato DOM
        TransformerFactory factoriaTransf = TransformerFactory.newInstance();
        Transformer transformador = factoriaTransf.newTransformer();
        DOMSource fuenteDom = new DOMSource(doc);
        StreamResult result = new StreamResult(System.out);
        // Crea un fichero contenedor compatible con el formato XML
        StreamResult resulFinal = new StreamResult(new File("src/peliculas.xml"));
        // Coloca la información ahora en formato DOM en un fichero XML
        transformador.transform(fuenteDom, resulFinal);
        System.out.println("¡Fichero creado y guardado!");
    }
    private void transformadorModificar(Document doc) throws TransformerException {
        //Prepara el documento XML resultante para mostrarlo por pantalla y grabarlo
        TransformerFactory factoriaTransf = TransformerFactory.newInstance();
        Transformer transformador = factoriaTransf.newTransformer();
        DOMSource source = new DOMSource(doc);
        //Indica el nombre del fichero sobre el que sobreescribirá tras la modificación
        StreamResult fileResult = new StreamResult(new File("src/peliculas.xml"));
        transformador.transform(source, fileResult);
    }
    private void transformadorEliminar(Document doc) throws TransformerException {
        //Prepara el documento XML resultante para mostrarlo por pantalla y grabarlo
        TransformerFactory factoriaTransf = TransformerFactory.newInstance();
        Transformer transformador = factoriaTransf.newTransformer();
        DOMSource source = new DOMSource(doc);
        System.out.println("Nodo eliminado");
        //Indica el nombre del fichero sobre el que sobreescribirá tras el borrado
        StreamResult fileResult = new StreamResult(new File("src/peliculas.xml"));
        transformador.transform(source, fileResult);
    }
}
