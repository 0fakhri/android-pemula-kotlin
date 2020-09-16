package com.kulitekno.submit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class about : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.about)
        supportActionBar!!.title = "About"
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

//        ActionBar actionBar = getActionBar();
//        actionBar.setDisplayHomeAsUpEnabled(true);
//
//        OnBackPressedCallback callback = new OnBackPressedCallback(true /* enabled by default */) {
//            @Override
//            public void handleOnBackPressed() {
//                // Handle the back button event
//            }
//        });
//        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);
    } //    @Override
    //    public boolean onOptionsItemSelected(MenuItem item){
    //        int id = item.getItemId();
    //
    //        if(id == R.id.home){
    //            this.finish();
    //        }
    //
    //        return super.onOptionsItemSelected(item);
    //    }
}