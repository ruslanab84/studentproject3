package io;

import model.Info;
import util.JsonUtil;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JsonWriter {

    private static final Logger logger = Logger.getLogger(JsonWriter.class.getName());

    private JsonWriter() {
    }

    public static void writeJsonReq(Info info) {

        logger.log(Level.INFO, "JSON writing started");

        try {
            Files.createDirectory(Paths.get("jsonReqs"));
            logger.log(Level.INFO, "Directory created successfully");
        } catch (IOException ioEx) {
            logger.log(Level.FINE, "Directory already created", ioEx);
        }

        writeStudents(info);
        writeUniversities(info);
        writeStatisticsList(info);

        logger.log(Level.INFO, "JSON writing finished successfully");
    }

    private static void writeStudents(Info info) {
        String studentsJson = JsonUtil.writeToJson(info.getStudents());
        try {
            FileOutputStream outputStream =
                    new FileOutputStream("jsonReqs/students" + info.getCreateDate().getTime() + ".json");
            outputStream.write(studentsJson.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Students JSON writing failed", e);
        }
    }

    private static void writeUniversities(Info info) {
        String universitiesJson = JsonUtil.writeToJson(info.getUniversities());
        try {
            FileOutputStream outputStream =
                    new FileOutputStream("jsonReqs/universities" + info.getCreateDate().getTime() + ".json");
            outputStream.write(universitiesJson.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Universities JSON writing failed", e);
        }
    }

    private static void writeStatisticsList(Info info) {
        String studentsJson = JsonUtil.writeToJson(info.getStatistics());
        try {
            FileOutputStream outputStream =
                    new FileOutputStream("jsonReqs/statistics" + info.getCreateDate().getTime() + ".json");
            outputStream.write(studentsJson.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Statistics JSON writing failed", e);
        }
    }
}