package edu.ina.proyecto_base;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MorseController {


    private static final Map<String, String> morseMap = new HashMap<>();

    static {

        morseMap.put(".-", "A");    morseMap.put("-...", "B");  morseMap.put("-.-.", "C");
        morseMap.put("-..", "D");   morseMap.put(".", "E");     morseMap.put("..-.", "F");
        morseMap.put("--.", "G");   morseMap.put("....", "H");  morseMap.put("..", "I");
        morseMap.put(".---", "J");  morseMap.put("-.-", "K");   morseMap.put(".-..", "L");
        morseMap.put("--", "M");    morseMap.put("-.", "N");    morseMap.put("---", "O");
        morseMap.put(".--.", "P");  morseMap.put("--.-", "Q");  morseMap.put(".-.", "R");
        morseMap.put("...", "S");   morseMap.put("-", "T");     morseMap.put("..-", "U");
        morseMap.put("...-", "V");  morseMap.put(".--", "W");   morseMap.put("-..-", "X");
        morseMap.put("-.--", "Y");  morseMap.put("--alle", "Z"); // por si acaso
        morseMap.put("--..", "Z");


        morseMap.put(".----", "1"); morseMap.put("..---", "2"); morseMap.put("...--", "3");
        morseMap.put("....-", "4"); morseMap.put(".....", "5"); morseMap.put("-....", "6");
        morseMap.put("--...", "7"); morseMap.put("---..", "8"); morseMap.put("----.", "9");
        morseMap.put("-----", "0");


        morseMap.put("..--..", "?");
        morseMap.put("-.-.--", "!");
        morseMap.put("--..--", ",");
    }

    @GetMapping("/traducir")
    public String traducirMorse(@RequestParam(value = "codigo", defaultValue = ".... --- .-.. .-") String codigo) {

        StringBuilder traduccionFinal = new StringBuilder();


        String[] palabras = codigo.split(" {3}");

        for (int i = 0; i < palabras.length; i++) {
            String palabraMorse = palabras[i];


            String[] letrasMorse = palabraMorse.split(" ");

            for (String letraM : letrasMorse) {
                if (!letraM.isEmpty()) {

                    String letraTraducida = morseMap.getOrDefault(letraM, "?");
                    traduccionFinal.append(letraTraducida);
                }
            }


            if (i < palabras.length - 1) {
                traduccionFinal.append(" ");
            }
        }


        return traduccionFinal.toString();
    }
}