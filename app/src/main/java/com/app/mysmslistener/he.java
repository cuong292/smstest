package com.app.mysmslistener;

import android.util.Log;

class he {
    public static void main(String[] args) {
        String s = "Xin 20 c{h}ào 60  #KT30@!Kids(Online)  100 ";
        s = s.trim();
        while (s.contains("  ")) {
            s = s.replaceAll("  ", " ");
        }
        s = s.replaceAll("[^a-zA-Z0-9\\s]", "");
        Log.d("cuongnb", "onCreate: " + s);
        String[] split = s.split(" ");
        if (split.length == 0) {
            Log.d("cuongnb", "onCreate: empty");
        }
        ;
        for (int i = split.length - 1; i >= 0; i--) {
            split[i] = split[i].toLowerCase();
            Log.d("cuongnb", split[i].substring(0, 1).toUpperCase().concat(split[i].substring(1)));
        }
        int count = 0;
        int total = 0;
        for (int i = 0; i <= split.length - 1; i++) {
            if (split[i].matches("^[0-9]+$")) {
                count += 1;
                total += Integer.parseInt(split[i]);
            }
        }
        double data = ((double) total) / ((double) count);
        if (data == 0) Log.d("cuongnb", "0");
        if (data == Math.round(data)) {
            Log.d("cuongnb", String.valueOf(data));
        } else {
            Log.d("cuongnb", String.format("%.1f", data));
        }

    }
}
