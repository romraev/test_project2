package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class JsonSaver implements DataSaver{
    @Override
    public void savePrize(Player player) {
        String fileName = String.format("Player_%s.json", player.getName());
        Date date = new Date();
        try (FileWriter writer = new FileWriter(fileName, false)) {
            writer.write("[\n");
            for (int i = 0; i < player.getWinList().size(); i++) {
                writer.write("\t{\n");
                writer.write(String.format("\t\t\"Игрушка\":\"%s\",\n", player.getWinList().get(i).getName()));
                writer.write(String.format("\t\t\"Артикул\":\"%d\",\n", player.getWinList().get(i).getId()));
                writer.write(String.format("\t\t\"Количество\":\"%d\",\n", player.getWinList().get(i).getCount()));
                writer.write(String.format("\t\t\"Дата и время выигрыша:\":\"%s\"\n", date));
                writer.write("\t}");
                if (i < player.getWinList().size() - 1) {
                    writer.write(",\n");
                }
            }
            writer.write("\n]");
            writer.flush();
            System.out.println("Выигрыш успешно сохранен!");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
