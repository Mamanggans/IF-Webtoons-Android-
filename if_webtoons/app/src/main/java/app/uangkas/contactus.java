package app.uangkas;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class contactus  extends AppCompatActivity {
    EditText name, email, message, tes;
    DatabaseReference reference;
    amessage req = new amessage();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_us);
        //memanggil id komponen
        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        message = (EditText) findViewById(R.id.message);
/*        tes = (EditText) findViewById(R.id.tes);*/
        final Button submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sName = name.getText().toString();
                String sEmail = email.getText().toString();
                String sMessage = message.getText().toString();
                reference = FirebaseDatabase.getInstance().getReference().child("amessage");

                getValue();
                if (sName.equals("") || sMessage.equals(""))
                {
                    Toast.makeText(contactus.this, "Data Tidak boleh kosong",
                            Toast.LENGTH_LONG).show();
                }
                else
                {
                    reference.push().setValue(req);
                    name.setText("");
                    email.setText("");
                    message.setText("");
                    Toast.makeText(contactus.this,"Data Tersimpan",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    private void getValue()
    {
        req.setName(name.getText().toString());
        req.setEmail(email.getText().toString());
        req.setMessage(message.getText().toString());
    }
}


