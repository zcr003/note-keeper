package edu.cnm.deepdive.notekeeper.service;

import android.app.Application;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;
import edu.cnm.deepdive.notekeeper.model.dao.NoteDao;
import edu.cnm.deepdive.notekeeper.model.entity.Note;
import java.util.Date;

@Database(
    entities = {Note.class},
    version = 1
)
@TypeConverters({NoteKeeperDatabase.Converters.class})
public abstract class NoteKeeperDatabase extends RoomDatabase {

  private static final String DB_NAME = "note-keeper-db";

  private static Application context;

  public static void setContext(Application context) {
    NoteKeeperDatabase.context = context;
  }

  public static NoteKeeperDatabase getInstance() {
    return InstanceHolder.INSTANCE;
  }

  public abstract NoteDao getNoteDao();

  private static class InstanceHolder {

    private static final NoteKeeperDatabase INSTANCE = Room
        .databaseBuilder(context, NoteKeeperDatabase.class, DB_NAME)
        .build();

  }

  public static class Converters {

    @TypeConverter
    public static Long toLong(Date value) {
      return (value != null) ? value.getTime() : null;
    }

    @TypeConverter
    public static Date toDate(Long value) {
      return (value != null) ? new Date(value) : null;
    }

  }

}
