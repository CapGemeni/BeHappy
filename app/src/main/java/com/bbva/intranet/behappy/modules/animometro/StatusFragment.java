package com.bbva.intranet.behappy.modules.animometro;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bbva.intranet.behappy.R;
import com.bbva.intranet.behappy.databinding.FragmentStatusBinding;
import com.bbva.intranet.behappy.models.Status;
import com.squareup.picasso.Picasso;

public class StatusFragment extends Fragment implements View.OnClickListener {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private int mPosition;
    private Status status;
    FragmentStatusBinding binding;
    public static final String ARG_STATUS = "status";
    public static final int POSITION_MEH = 0;
    public static final int POSITION_ENOJADO = 1;
    public static final int POSITION_SUPER_FELIZ = 2;
    public static final int POSITION_BIEN = 3;
    public static final int POSITION_TRISTE = 4;
    private DescriptionStatusDialog dFragment;
    private View view;

    public StatusFragment() {
        // Required empty public constructor
    }

    public static StatusFragment newInstance(int position, Status status) {
        StatusFragment fragment = new StatusFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, position);
        args.putSerializable(ARG_PARAM2, status);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mPosition = getArguments().getInt(ARG_PARAM1);
            status = (Status) getArguments().getSerializable(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_status, container, false);
        init();
        binding.btnEstado.setOnClickListener(this);
        return binding.getRoot();
    }

    private void init() {
        if (status.getImage() == null){
                    binding.ivEstado.setImageResource(status.getImageResId());
        } else {
            Picasso.get()
                    .load(status.getImage())
                    .error(status.getImageResId())
                    .resize(368, 368)
                    .into(binding.ivEstado);
        }
        binding.btnEstado.setBackgroundResource(status.getBtnResId());
        binding.btnEstado.setText(status.getTitle());

        /*
        switch (mPosition){
            case POSITION_MEH:
                binding.ivEstado.setImageResource(R.mipmap.ic_animometro_meh);
                binding.btnEstado.setBackgroundResource(R.drawable.btn_solid_aqua);
                binding.btnEstado.setText(R.string.label_animometro_meh);
                break;
            case POSITION_ENOJADO:
                binding.ivEstado.setImageResource(R.mipmap.ic_animometro_enojado);
                binding.btnEstado.setBackgroundResource(R.drawable.btn_solid_red);
                binding.btnEstado.setText(R.string.label_animometro_enojado);
                break;
            case POSITION_SUPER_FELIZ:
                binding.ivEstado.setImageResource(R.mipmap.ic_animometro_super_feliz);
                binding.btnEstado.setBackgroundResource(R.drawable.btn_solid_yellow);
                binding.btnEstado.setText(R.string.label_animometro_super_feliz);
                break;
            case POSITION_BIEN:
                binding.ivEstado.setImageResource(R.mipmap.ic_animometro_bien);
                binding.btnEstado.setBackgroundResource(R.drawable.btn_solid_pink);
                binding.btnEstado.setText(R.string.label_animometro_bien);
                break;
            case POSITION_TRISTE:
                binding.ivEstado.setImageResource(R.mipmap.ic_animometro_triste);
                binding.btnEstado.setBackgroundResource(R.drawable.btn_solid_blue);
                binding.btnEstado.setText(R.string.label_animometro_triste);
                break;
            default:
                binding.ivEstado.setImageResource(R.mipmap.ic_animometro_meh);
                binding.btnEstado.setBackgroundResource(R.drawable.btn_solid_aqua);
                binding.btnEstado.setText(R.string.label_animometro_meh);
                break;
        }
        */
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_estado){
            dFragment = DescriptionStatusDialog.newInstance(mPosition,status,  new DescriptionStatusDialog.DescriptionStatusDialogListener(){
                @Override
                public void onContinue() {

                }
            });
            FragmentManager fm = getFragmentManager();
            dFragment.show(fm, "Dialog Fragment");
        }
    }
}
