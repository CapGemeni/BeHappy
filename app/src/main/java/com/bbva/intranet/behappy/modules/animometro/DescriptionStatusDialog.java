
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
import com.bbva.intranet.behappy.databinding.DialogDescriptionStatusBinding;
import com.bbva.intranet.behappy.models.Status;

public class DescriptionStatusDialog extends DialogFragment implements OnClickListener {

    private DescriptionStatusDialogListener listener;
    private int statusIndex;
    private Status status;

    private DialogDescriptionStatusBinding binding;

    public static DescriptionStatusDialog newInstance(int statusIndex, Status status, DescriptionStatusDialogListener listener) {
        DescriptionStatusDialog frag = new DescriptionStatusDialog();
        Bundle args = new Bundle();
        frag.listener = listener;
        frag.statusIndex = statusIndex;
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

        binding = DataBindingUtil.inflate(inflater, R.layout.dialog_description_status, null, false);
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
        binding.tvStatus.setText(status.getTitle());
        binding.tvStatusDesc.setText(status.getDescriptionResId());
        binding.btnContinue.setBackgroundResource(status.getBtnResId());
        /*
        if (status == StatusFragment.POSITION_MEH) {
            binding.containerColor.setBackgroundColor(getResources().getColor(R.color.aqua));
            binding.tvStatus.setText(R.string.label_animometro_meh);
            binding.tvStatusDesc.setText(R.string.label_animometro_meh_desc);
            binding.btnContinue.setBackgroundResource(R.drawable.btn_solid_aqua);
        }
        if (status == StatusFragment.POSITION_ENOJADO) {
            binding.containerColor.setBackgroundColor(getResources().getColor(R.color.red));
            binding.tvStatus.setText(R.string.label_animometro_enojado);
            binding.tvStatusDesc.setText(R.string.label_animometro_enojado_desc);
            binding.btnContinue.setBackgroundResource(R.drawable.btn_solid_red);
        }
        if (status == StatusFragment.POSITION_SUPER_FELIZ) {
            binding.containerColor.setBackgroundColor(getResources().getColor(R.color.yellow));
            binding.tvStatus.setText(R.string.label_animometro_super_feliz);
            binding.tvStatusDesc.setText(R.string.label_animometro_super_feliz_desc);
            binding.btnContinue.setBackgroundResource(R.drawable.btn_solid_yellow);
        }
        if (status == StatusFragment.POSITION_BIEN) {
            binding.containerColor.setBackgroundColor(getResources().getColor(R.color.pink));
            binding.tvStatus.setText(R.string.label_animometro_bien);
            binding.tvStatusDesc.setText(R.string.label_animometro_bien_desc);
            binding.btnContinue.setBackgroundResource(R.drawable.btn_solid_pink);
        }
        if (status == StatusFragment.POSITION_TRISTE) {
            binding.containerColor.setBackgroundColor(getResources().getColor(R.color.blue));
            binding.tvStatus.setText(R.string.label_animometro_triste);
            binding.tvStatusDesc.setText(R.string.label_animometro_triste_desc);
            binding.btnContinue.setBackgroundResource(R.drawable.btn_solid_blue);
        }
        */

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
            Intent intent = new Intent(getActivity(), CuentanosMasActivity.class);
            intent.putExtra(StatusFragment.ARG_STATUS, status);
            startActivity(intent);
            dismiss();
        }
    }

    @Override
    public void dismiss() {
        super.dismiss();
    }

    public interface DescriptionStatusDialogListener{
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
