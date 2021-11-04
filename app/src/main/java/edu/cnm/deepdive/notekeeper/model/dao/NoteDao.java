package edu.cnm.deepdive.notekeeper.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.notekeeper.model.entity.Note;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

@Dao
public interface NoteDao {

  @Insert
  Single<Long> insert(Note note);

  @Insert
  Single<List<Long>> insert(Note... notes);

  @Insert
  Single<List<Long>> insert(Collection<Note> notes);

  @Update
  Single<Integer> update(Note note);

  @Update
  Single<Integer> update(Note... notes);

  @Update
  Single<Integer> update(Collection<Note> notes);

  @Delete
  Single<Integer> delete(Note note);

  @Delete
  Single<Integer> delete(Note... notes);

  @Delete
  Single<Integer> delete(Collection<Note> notes);

  @Query("SELECT * FROM note WHERE note_id = :noteId")
  LiveData<Note> select(long noteId);

  @Query("SELECT * FROM note ORDER BY created DESC")
  LiveData<List<Note>> selectAllOrderByCreatedDesc();

  @Query("SELECT * FROM note ORDER BY updated DESC")
  LiveData<List<Note>> selectAllOrderByUpdatedDesc();

  @Query("SELECT * FROM note ORDER BY subject ASC")
  LiveData<List<Note>> selectAllOrderBySubjectAsc();

}
