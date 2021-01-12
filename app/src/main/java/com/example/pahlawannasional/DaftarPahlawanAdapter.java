package com.example.pahlawannasional;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.pahlawannasional.model.Pahlawan;

import java.util.List;

public class DaftarPahlawanAdapter extends ArrayAdapter<Pahlawan> {
    Context context;

    public DaftarPahlawanAdapter(@NonNull Context context, @NonNull List<Pahlawan> objects) {
        super(context, R.layout.row_pahlawan, objects);
        this.context = context;
    }

    class ViewHolder {
        TextView txTgl;
        TextView txNilai;
        TextView txDeskripsi;
        TextView txModel;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Pahlawan tr = getItem(position);
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.row_pahlawan,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.txTgl = convertView.findViewById(R.id.row_tx_tgl_transaksi);
            viewHolder.txDeskripsi = convertView.findViewById(R.id.row_tx_desc_transaksi);
            viewHolder.txNilai = convertView.findViewById(R.id.row_tx_nilai_transaksi);
            viewHolder.txModel = convertView.findViewById(R.id.row_tx_model);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.txTgl.setText(GenericUtility.DATE_FORMAT.format(tr.getTanggal()));
        viewHolder.txDeskripsi.setText(tr.getDeskripsi());
        viewHolder.txModel.setText(tr.getModel());
        if (tr.getJenis().equals(Pahlawan.NASIONAL)) {
            viewHolder.txNilai.setText(tr.getNilai());
        } else {
            viewHolder.txNilai.setText((tr.getNilai()));
        }
        return convertView;
    }
}
