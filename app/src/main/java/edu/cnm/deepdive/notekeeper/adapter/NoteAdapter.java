package edu.cnm.deepdive.notekeeper.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import edu.cnm.deepdive.notekeeper.databinding.ItemNoteBinding;
import edu.cnm.deepdive.notekeeper.model.entity.Note;
import java.text.DateFormat;
import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.Holder> {

  private final LayoutInflater inflater;
  private final DateFormat dateFormat;
  private final List<Note> notes;

  public NoteAdapter(Context context, List <Note> notes) {
    inflater = LayoutInflater.from(context);
    dateFormat = android.text.format.DateFormat.getDateFormat(context);
    this.notes = notes;
  }

  @NonNull
  @Override
  public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    return new Holder(ItemNoteBinding.inflate(inflater, parent, false));
  }

  @Override
  public void onBindViewHolder(@NonNull Holder holder, int position) {
    holder.bind(position);

  }

  @Override
  public int getItemCount() {
    return notes.size();
  }

  class Holder extends RecyclerView.ViewHolder {

    private final ItemNoteBinding binding;

    private Holder(@NonNull ItemNoteBinding binding) {
      super(binding.getRoot());
      this.binding = binding;
    }

    //Taking setText data and putting it in our view object
    private void bind(int position) {
      Note note = notes.get(position);
      binding.subject.setText(note.getSubject());
      binding.updated.setText(dateFormat.format(note.getUpdated()));
      binding.text.setText(note.getText());
    }
  }

}
