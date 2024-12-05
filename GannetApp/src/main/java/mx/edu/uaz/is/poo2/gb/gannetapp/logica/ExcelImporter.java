package mx.edu.uaz.is.poo2.gb.gannetapp.logica;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelImporter {

    private final Controladora controladora;

    public ExcelImporter() {
        this.controladora = new Controladora(); 
    }

    public void importarAgroquimicos(String filePath) {
        List<Agroquimico> agroquimicos = leerExcel(filePath);

        // Guardar en la base de datos
        for (Agroquimico agro : agroquimicos) {
            controladora.agregarAgroquimico(
                agro.getNombre(),
                agro.getCategoria(),
                agro.getTipoPlaga(),
                agro.getPrecio(),
                agro.getAlcance(),
                agro.getCapacidad()
            );
        }
        System.out.println("Importación completada. " + agroquimicos.size() + " registros agregados.");
    }

    private List<Agroquimico> leerExcel(String filePath) {
        List<Agroquimico> agroquimicos = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(new File(filePath));
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0); // Leer la primera hoja
            for (Row row : sheet) {
                if (row.getRowNum() == 0) continue; // Saltar el encabezado

                // Crear un nuevo objeto Agroquimico con los datos del Excel
                Agroquimico agro = new Agroquimico();
                agro.setNombre(row.getCell(0).getStringCellValue());
                agro.setCategoria(row.getCell(1).getStringCellValue());
                agro.setTipoPlaga(row.getCell(2).getStringCellValue());
                agro.setPrecio((int) row.getCell(3).getNumericCellValue());
                agro.setAlcance((int) row.getCell(4).getNumericCellValue());
                agro.setCapacidad((int) row.getCell(5).getNumericCellValue());

                agroquimicos.add(agro);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error al leer el archivo Excel: " + e.getMessage());
        }

        return agroquimicos;
    }
}
