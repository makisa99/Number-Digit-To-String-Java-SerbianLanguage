/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package broj_u_rec;

/**
 *
 * @author Aki
 */
public class Broj_u_rec {

    /**
     * @param args the command line arguments
     */
    //Da konvertuje do 999
    public static void main(String[] args) {
       int broj = 234;

        System.out.println(konverzija(broj));
    }
    static final String[] brojevi = {
        "",
        "jedan",
        "dva",
        "tri",
        "cetiri",
        "pet",
        "sest",
        "sedam",
        "osam",
        "devet",
        "deset",
        "jedanaest",
        "dvanaest",
        "trinaest",
        "cetrnaest",
        "petnaest",
        "sesnaest",
        "sedamnaest",
        "osamnaest",
        "devetnaest"
    };
    static final String[] desetice = {
        "",
        "deset",
        "dvadeset",
        "trideset",
        "cetirdeset",
        "pedeset",
        "sezdeset",
        "sedamdeset",
        "osamdeset",
        "devedeset"
    };
    static final String[] stotine = {
        "",
        "sto",
        "dvesta",
        "trista",
        "cetiristo",
        "petsto",
        "seststo",
        "sedamsto",
        "osamsto",
        "devetsto"
    };

    /*private static String konverzija(int x) {
        String povrat = "";
        String brojHiljada = "";
        if (x > 999) {
            brojHiljada = konverzijaDo999(x / 1000);
            if (x % 1000 == 0){
                povrat = brojHiljada + " hiljada";
            }
            else
            povrat = brojHiljada + " hiljada " + konverzijaDo999(x % 1000); 
        } else {
            povrat = konverzijaDo999(x);
        }
        return povrat;
    }*/
    private static String izracunajHiljade(int x) {
        if ((x / 1000) % 10 == 2 || (x / 1000) % 10 == 3 || (x / 1000) % 10 == 4) {
            return " hiljade ";
        } else {
            return " hiljada ";
        }
    }

    private static String konverzija(int x) {
        String povrat = "";
        String temp;
        String brojHiljada = "";
        if (x > 999) {
            brojHiljada = konverzijaDo999(x / 1000);
			try{
            if (brojHiljada.substring(brojHiljada.length() - 5, brojHiljada.length()).equals("jedan")) {
                brojHiljada = brojHiljada.substring(0, brojHiljada.length() - 5) + "jedna";
            } else if (brojHiljada.substring(brojHiljada.length() - 3, brojHiljada.length()).equals("dva")) {
                brojHiljada = brojHiljada.substring(0, brojHiljada.length() - 3) + "dve";
				}
			}
			catch(Exception e){
			//	System.out.println(e.getMessage());
			}
            if (x % 1000 == 0) {
                povrat = brojHiljada + izracunajHiljade(x);
            } else {
                povrat = brojHiljada + izracunajHiljade(x) + konverzijaDo999(x % 1000);
            }
        } else {
            povrat = konverzijaDo999(x);
        }
        return povrat;
    }

    private static String konverzijaDo999(int x) {
        String povrat = "";
        String stotina = "";
        boolean veciodsto = false;
        if (x == 0) {
            return "nula";
        }
        if (x > 99) {
            stotina = stotine[x / 100];
            veciodsto = true;
        }
        if (x % 100 < 20) { // kad je manji od 20
            if (veciodsto) {
                povrat = stotina + " " + brojevi[x % 100];
            } else {
                povrat = brojevi[x % 100];
            }
            x /= 100;
        } else { //ovde su jedinice
            //  if (veciodsto) {
            //      povrat = povrat + " " + brojevi[x % 10];
            //   } else {
            povrat = brojevi[x % 10];
            //   }
            x /= 10;

            povrat = stotina + " " + desetice[x % 10] + " " + povrat; // ovo su desetice
            x /= 10;
        }
        if (x == 0) {
            return povrat.trim();
        }
        return povrat.trim();
    }
}
