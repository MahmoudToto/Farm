package com.example.farm.repo.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.farm.pojo.Farm;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Farm.class}, version = 1, exportSchema = false)
public abstract class FarmeData extends RoomDatabase {

    public abstract FarmDao farmDao();

    private static volatile FarmeData INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static FarmeData getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (FarmeData.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            FarmeData.class, "word_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
