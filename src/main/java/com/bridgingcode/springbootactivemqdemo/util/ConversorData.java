package com.bridgingcode.springbootactivemqdemo.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ConversorData {

    public static String converteDataDiaMesAno(Date data) {
        SimpleDateFormat dia_mes_ano = new SimpleDateFormat("dd/MM/yyyy");
        return dia_mes_ano.format(data);
    }

}
