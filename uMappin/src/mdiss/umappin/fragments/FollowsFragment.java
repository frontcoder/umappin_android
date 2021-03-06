package mdiss.umappin.fragments;



import mdiss.umappin.R;

import mdiss.umappin.adapters.FollowersAdapter;
import mdiss.umappin.adapters.FollowingAdapter;
import mdiss.umappin.entities.User;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

public class FollowsFragment extends ListFragment implements OnClickListener{
	
	
	/**
	 * Android needs empty constructor to recreate the fragment if something 
	 * goes wrong. Then use setDiscussionHeaders. 
	 */
	private User profileUser;
	private Boolean followsFollowed; //false followers True following

	private ListView list;
	private BaseAdapter adapter;



	public FollowsFragment() {
	}
	
	public void setProfileData(User pUser,Boolean followsFollowed){
		profileUser = pUser;
		this.followsFollowed = followsFollowed;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.follow_list,container,false);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		list=(ListView) getListView();
		
		if(followsFollowed){
			//Following Adapter have to change to followeds
			//TODO
			adapter=new FollowingAdapter(getActivity(),profileUser);
			getActivity().getActionBar().setTitle("Follows");

		}else{
			adapter=new FollowersAdapter(getActivity(), profileUser);
			getActivity().getActionBar().setTitle("Followers");
		}
		
        list.setAdapter(adapter);
		
	}


	@Override
	public void onClick(View v) {
		
	}
	
	
	
}
