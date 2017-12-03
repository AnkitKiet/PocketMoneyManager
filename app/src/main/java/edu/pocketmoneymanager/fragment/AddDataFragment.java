package edu.pocketmoneymanager.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import edu.pocketmoneymanager.R;
import edu.pocketmoneymanager.databinding.AddFragment;
import edu.pocketmoneymanager.databinding.FragmentAddDataBinding;
import edu.pocketmoneymanager.presenter.AddDataFragmentPresenter;

/**
 * Created by Ankit on 03/12/17.
 */

public class AddDataFragment extends Fragment {

    private View parentView;
    AddFragment addFragment;

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
        populate(binding, addFragment);
        Toast.makeText(getActivity(), "valie", Toast.LENGTH_SHORT).show();
        return parentView;
    }

    private void populate(final FragmentAddDataBinding binding, final AddFragment addFragment) {

        parentView.findViewById(R.id.fabAdd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddDataFragmentPresenter addDataPresenter = new AddDataFragmentPresenter();
                EditText edtDetails = (EditText) parentView.findViewById(R.id.edtDetails);
                EditText edtMoney = (EditText) parentView.findViewById(R.id.edtAmount);
                addFragment.setMoney(Long.parseLong(!edtMoney.getText().toString().equals("")?edtMoney.getText().toString():"0"));
                addFragment.setDetails(edtDetails.getText().toString());
                binding.setAddfragment(addFragment);
                addDataPresenter.addData(getActivity(), binding.getAddfragment().getMoney(), binding.getAddfragment().getDetails());
            }
        });

    }
}
