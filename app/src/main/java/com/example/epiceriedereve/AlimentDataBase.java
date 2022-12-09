package com.example.epiceriedereve;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;

@Database(entities = {Aliment.class}, version=1)
public abstract class AlimentDataBase {
    public abstract AlimentDao alimentDao();
    private static AlimentDataBase instance;

    public static AlimentDataBase getDataBase(final Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    AlimentDataBase.class, "aliment-database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
