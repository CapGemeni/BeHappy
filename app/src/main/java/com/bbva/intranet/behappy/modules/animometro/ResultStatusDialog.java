
package com.bbva.intranet.behappy.modules.animometro;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import com.bbva.intranet.behappy.R;
import com.bbva.intranet.behappy.databinding.DialogResultStatusBinding;
import com.bbva.intranet.behappy.models.Status;

public class ResultStatusDialog extends DialogFragment implements OnClickListener {

    private ResultStatusDialogListener listener;

    private DialogResultStatusBinding binding;
    private Status status;

    public static ResultStatusDialog newInstance(Status status, ResultStatusDialogListener listener) {
        ResultStatusDialog frag = new ResultStatusDialog();
        Bundle args = new Bundle();
        frag.listener = listener;
        frag.status = status;
        frag.setArguments(args);
        return frag;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setStyle(STYLE_NO_TITLE, R.style.Theme_Dialog_Transparents);
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.dialog_result_status, null, false);
        init();
        setListeners();
        return binding.getRoot();
    }

    private void setListeners() {
        binding.btnClose.setOnClickListener(this);
        binding.btnContinue.setOnClickListener(this);
    }

    private void init() {
        binding.containerColor.setBackgroundColor(getResources().getColor(status.getBgColorResId()));
        //binding.tvStatus.setText(status.getTitle());
        binding.tvStatus.setText(R.string.label_puntos_ganados);
        //binding.tvStatusDesc.setText(status.getDescriptionResId());
        binding.btnContinue.setBackgroundResource(status.getBtnResId());
    }

    @Override
    public void onStart() {
        super.onStart();
        if (getDialog() == null) {
            return;
        }
        getDialog().getWindow().setWindowAnimations(R.style.dialog_animation_enter_top_to_bottom);
    }



    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_close){
            dismiss();
        }
        if (v.getId() == R.id.btn_continue){
            Intent intent = new Intent(getActivity(), EstadisticaActivity.class);
            startActivity(intent);
            dismiss();
        }
    }

    @Override
    public void dismiss() {
        super.dismiss();
    }

    public interface ResultStatusDialogListener{
        public void onContinue();
    }

    @Override
    public int show(FragmentTransaction transaction, String tag) {
        transaction.add(this, tag);
        return transaction.commitAllowingStateLoss();
    }

    @Override
    public void show(FragmentManager manager, String tag) {
        FragmentTransaction ft = manager.beginTransaction();
        ft.add(this, tag);
        ft.commitAllowingStateLoss();
    }
}
