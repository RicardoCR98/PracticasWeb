<?php 
class producto{

    function __construct(){

    }

    function getContenidoES(){
        $fp = fopen("./modelo/categorias_es.txt","r");
        $contenidoES = array();

        while(!feof($fp)){
            $texto = fgets($fp);
            $contenidoES[] = $texto;
        }

        fclose($fp);
        return $contenidoES;
    }

    function getContenidoEN() {
        $fp = fopen("./modelo/categorias_en.txt", "r");
        $contenidoEN = array();
    
        while (!feof($fp)) {
            $texto = fgets($fp);
            $contenidoEN[] = $texto;
        }
    
        fclose($fp);
    
        return $contenidoEN;
    }
}



?>