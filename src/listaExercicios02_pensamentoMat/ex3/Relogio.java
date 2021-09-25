package listaExercicios02_pensamentoMat.ex3;

public class Relogio {

    private String horario = "";

    public Relogio(String horario) {
        this.horario = horario;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public void proximoMinuto() {

        String[] lstHorario = this.horario.split(":");
        int horas = Integer.parseInt(lstHorario[0]);
        int minutos = Integer.parseInt(lstHorario[1]);



        if ((minutos + 1) > 59 & horas < 23) {
            horas += 1;
            this.horario = horas + ":" + "00";
        }else if ((minutos + 1) > 59 & horas == 23) {
            this.horario = "00:00";
        }else {

            minutos += 1;
            String min = Integer.toString(minutos);
            String hrs = Integer.toString(horas);
            if (minutos >= 1 & minutos <= 9) {
                min = "0" + min;
            }
            if (horas == 0) {
                hrs = horas + "0";
            }

            this.horario = hrs + ":" + min;
        }
    }
    public void imprimirHora() {

        System.out.println(this.horario);

    }

    public void imprimirUmDia(){
        this.horario = "00:00";
        for (int h = 0; h < 24; h++){
            for (int m = 0; m <= 59; m++) {
                proximoMinuto();
                imprimirHora();
            }
            System.out.println("============");
        }
    }
}
