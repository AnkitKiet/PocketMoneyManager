package edu.pocketmoneymanager.fragment;

import android.app.DatePickerDialog;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

import edu.pocketmoneymanager.R;
import edu.pocketmoneymanager.activities.BaseActivity;
import edu.pocketmoneymanager.databinding.AddFragment;
import edu.pocketmoneymanager.databinding.FragmentAddDataBinding;
import edu.pocketmoneymanager.presenter.AddDataFragmentPresenter;

/**
 * Created by Ankit on 03/12/17.
 */

public class AddDataFragment extends Fragment implements DatePickerDialog.OnDateSetListener {

    private View parentView;
    AddFragment addFragment;
    private Date date;
    private DatePickerDialog datePickerDialog;
    private Calendar calendar;
    TextView txtBalance;
    BaseActivity baseActivity;

    public AddDataFragment() {
        //Default Fragment
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentAddDataBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_data, container, false);
        parentView = binding.getRoot();
        addFragment = new AddFragment("Enter Details", 0);
        binding.setAddfragment(addFragment);
        baseActivity = new BaseActivity();
        String totalMoney = String.valueOf(baseActivity.getTotalMoney(getActivity()));
        txtBalance = (TextView) parentView.findViewById(R.id.txtBalance);
        txtBalance.setText("Wallet Money : " + getActivity().getResources().getString(R.string.Rs) + " " + totalMoney + "/-");
        populate(binding, addFragment);
        return parentView;
    }

    private void populate(final FragmentAddDataBinding binding, final AddFragment addFragment) {
        calendar = Calendar.getInstance();
        datePickerDialog = new DatePickerDialog(getActivity(), this, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
        parentView.findViewById(R.id.btnSync).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String totalMoney = String.valueOf(baseActivity.getTotalMoney(getActivity()));
                txtBalance.setText("Wallet Money : " + getActivity().getResources().getString(R.string.Rs) + " " + totalMoney + "/-");
            }
        });

        parentView.findViewById(R.id.fabAdd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddDataFragmentPresenter addDataPresenter = new AddDataFragmentPresenter();
                EditText edtDetails = (EditText) parentView.findViewById(R.id.edtDetails);
                EditText edtMoney = (EditText) parentView.findViewById(R.id.edtAmount);
                CheckBox chkAdd = (CheckBox) parentView.findViewById(R.id.chkAdd);
                addFragment.setMoney(Long.parseLong(!edtMoney.getText().toString().equals("") ? edtMoney.getText().toString() : "0"));
                addFragment.setDetails(edtDetails.getText().toString());
                binding.setAddfragment(addFragment);
                addDataPresenter.addData(getActivity(), binding.getAddfragment().getMoney(), binding.getAddfragment().getDetails(), date, chkAdd.isChecked());
                String totalMoney = String.valueOf(baseActivity.getTotalMoney(getActivity()));
                txtBalance.setText("Wallet Money : " + getActivity().getResources().getString(R.string.Rs) + " " + totalMoney + "/-");
            }
        });

    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        date = calendar.getTime();

    }
}
