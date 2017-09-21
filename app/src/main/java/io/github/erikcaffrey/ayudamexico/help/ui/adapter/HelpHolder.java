package io.github.erikcaffrey.ayudamexico.help.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.github.erikcaffrey.ayudamexico.R;
import io.github.erikcaffrey.ayudamexico.help.model.Hospital;
import io.github.erikcaffrey.ayudamexico.help.presenter.HelpPresenter;

/**
 * Created by hackro on 21/09/17.
 */

public class HelpHolder extends RecyclerView.ViewHolder  {

    private HelpPresenter presenter;

    @BindView(R.id.nivel)
    TextView nivel;

    @BindView(R.id.title_help_no_required)
    TextView title_help_no_required;

    @BindView(R.id.help_required)
    TextView help_required;

    @BindView(R.id.help_no_required)
    TextView help_no_required;

    @BindView(R.id.direction)
    TextView direction;


    @BindView(R.id.zone)
    TextView zone;


    @BindView(R.id.detail)
    TextView detail;

    @BindView(R.id.date_update)
    TextView date_update;


    public HelpHolder(View itemView, HelpPresenter presenter) {
        super(itemView);
        this.presenter = presenter;
        ButterKnife.bind(this,itemView);
    }

    private void onItemClick(final Hospital hospital) {
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onItemClick(hospital);
            }
        });
    }

        public void render(Hospital hospital) {
            onItemClick(hospital);
            renderNivel(hospital);

            help_required.setText(hospital.getHelpRequired());
            renderNoRequired(hospital);
            direction.setText(hospital.getAddress());
            zone.setText(hospital.getZone());
            detail.setText(hospital.getDetail());
            date_update.setText(hospital.getUpdateDate());

    }

    private void renderNoRequired(Hospital hospital) {
        if (hospital.getNotRequired().trim().equals("")){
            title_help_no_required.setVisibility(View.GONE);
            help_no_required.setVisibility(View.GONE);
        }else{
            help_no_required.setText(hospital.getNotRequired());
        }
    }

    private void renderNivel(Hospital hospital) {

        String nivelText = hospital.getLevelOfUrgency().toLowerCase().trim();

            if (nivelText.equalsIgnoreCase("alto"))
                nivel.setBackgroundResource(R.color.colorTop);
            else if (nivelText.equalsIgnoreCase("medio"))
                nivel.setBackgroundResource(R.color.colorMiddle);
            else if (nivelText.equalsIgnoreCase("bajo"))
                nivel.setBackgroundResource(R.color.colorLow);


        nivel.setText(hospital.getLevelOfUrgency());
    }
}
