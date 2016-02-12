package io.anotherhermit.serviceinfoviewer;

import android.app.ActivityManager;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements AdapterView.OnItemClickListener {

    private ArrayAdapter<RunningServiceWrapper> mServices;
    private ListView mServiceList;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mServices = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1);
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        mServiceList = (ListView)rootView.findViewById(R.id.service_list);
        mServiceList.setAdapter(mServices);
        mServiceList.setOnItemClickListener(this);
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        Context ctx = getActivity().getApplicationContext();
        ActivityManager mgr =
                (ActivityManager)ctx.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningServiceInfo> srvInfo =
                mgr.getRunningServices(Integer.MAX_VALUE);
        mServices.clear();
        for (ActivityManager.RunningServiceInfo curSrv : srvInfo) {
            RunningServiceWrapper wrap = new RunningServiceWrapper(curSrv);
            mServices.add(wrap);
        }
        mServices.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        RunningServiceWrapper curItem = mServices.getItem(position);
        ServiceDetailFragment frag = ServiceDetailFragment.newInstance(curItem.getInfo());
        FragmentManager fm = getActivity().getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.main, frag);
        ft.addToBackStack(null);
        ft.commit();

    }

    private class RunningServiceWrapper {
        private ActivityManager.RunningServiceInfo mInfo;
        public RunningServiceWrapper(ActivityManager.RunningServiceInfo info) {
            mInfo = info;
        }

        public ActivityManager.RunningServiceInfo getInfo() {
            return mInfo;
        }

        public String toString() {
            return mInfo.service.flattenToShortString();
        }
    }
}
