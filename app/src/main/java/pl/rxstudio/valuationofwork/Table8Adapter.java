package pl.rxstudio.valuationofwork;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class Table8Adapter extends ArrayAdapter<Table8Item> {
    public Table8Adapter(Context context, ArrayList<Table8Item> table8List) {
        super(context, 0, table8List);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    private View initView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.table8_pzt_spinner_row, parent, false
            );
        }

        TextView textViewUse = convertView.findViewById(R.id.textViewUse);
        EditText editTextSize = convertView.findViewById(R.id.editTextSize);
        EditText editTextAdds = convertView.findViewById(R.id.editTextAdds);

        Table8Item currentItem = getItem(position);

        if(currentItem != null) {
            textViewUse.setText(currentItem.getTable8Use());
            editTextAdds.setText(currentItem.getTable8Add());
            editTextSize.setText(Double.toString(currentItem.getTable8Size()));
        }
        return convertView;


    }
}
