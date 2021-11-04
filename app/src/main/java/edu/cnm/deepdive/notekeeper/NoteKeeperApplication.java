package edu.cnm.deepdive.notekeeper;

import android.app.Application;
import com.facebook.stetho.Stetho;
import edu.cnm.deepdive.notekeeper.service.NoteKeeperDatabase;
import io.reactivex.schedulers.Schedulers;

public class NoteKeeperApplication extends Application {

  public NoteKeeperApplication() {
    super();
    Stetho.initializeWithDefaults(this);
    NoteKeeperDatabase.setContext(this);
    NoteKeeperDatabase
        .getInstance()
        .getNoteDao()
        .delete()
        .subscribeOn(Schedulers.io())
        .subscribe();
  }

}
