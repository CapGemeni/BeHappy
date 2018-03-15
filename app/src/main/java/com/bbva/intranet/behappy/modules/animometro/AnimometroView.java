package com.bbva.intranet.behappy.modules.animometro;

import com.bbva.intranet.behappy.models.Status;

import java.util.List;

public interface AnimometroView {
    void showProgress();
    void hideProgress();
    void createStatus(List<Status> status);
    void navigateToStatistics();
}
