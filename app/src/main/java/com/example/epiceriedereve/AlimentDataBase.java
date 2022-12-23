package com.example.epiceriedereve;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

/**
 * Base de données d'aliments.
 */
@Database(entities = {Aliment.class}, version=3)
public abstract class AlimentDataBase extends RoomDatabase {
    public abstract AlimentDao alimentDao();
    private static AlimentDataBase instance;

    /**
     * Retourne la database contenant les aliments de l'épicerie.
     * @param context
     * @return
     */
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
