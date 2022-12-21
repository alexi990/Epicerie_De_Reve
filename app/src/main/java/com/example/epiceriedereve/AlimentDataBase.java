package com.example.epiceriedereve;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Aliment.class}, version=3)
public abstract class AlimentDataBase extends RoomDatabase {
    public abstract AlimentDao alimentDao();
    private static AlimentDataBase instance;

    public static AlimentDataBase getDatabase(final Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    AlimentDataBase.class, "aliment-database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
