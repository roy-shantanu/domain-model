package com.company.repository.impl;

import com.company.domain.BaseEntity;

import java.io.*;
import java.util.Collection;

/**
 * User: Shantanu Roy
 * Date: 30-Oct-17
 * Time: 11:13 PM
 */
abstract class BaseDaoFileImpl {

    File entityFile(String folderName, String fileName) throws IOException {

        String BASE_PATH = "C:\\Users\\Shantanu Roy\\Desktop\\Test";
        File directory = new File(BASE_PATH + "\\" + folderName);
        File file = new File(BASE_PATH + "\\" + folderName + "\\" + fileName + ".ser");

        if (!file.exists()) {
            directory.mkdirs();
            file.createNewFile();
        }

        return file;
    }

    <T extends BaseEntity> Long getNewId(Collection<T> dataSet) {
        return dataSet.stream().mapToLong(BaseEntity::getId).max().orElse(0) + 1;
    }

    <T> void writeObjectToFile(T object, File file) throws IOException {

        FileOutputStream fileOut = new FileOutputStream(file);
        ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
        try {
            objectOut.writeObject(object);
        } finally {
            fileOut.close();
            objectOut.close();
        }

    }

    Object readObject(File file) throws IOException, ClassNotFoundException {

        FileInputStream fileIn = new FileInputStream(file.getAbsolutePath());
        ObjectInputStream readFile = new ObjectInputStream(fileIn);

        try {
            return readFile.readObject();
        } catch (EOFException e) {
            return null;
        }finally {
            fileIn.close();
            readFile.close();
        }
    }
}