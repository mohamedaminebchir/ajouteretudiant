package com.example.myapplication2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Edit Text;
import android.widget.Text View;

public class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
//add student
public class addstudent extends AppCompatActivity {
        private EditText editTextName;
        private EditText editTextAge;
        private Button buttonAdd;
        private StudentController studentController;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_add_student);

            editTextName = findViewById(R.id.editTextName);
            editTextAge = findViewById(R.id.editTextAge);
            buttonAdd = findViewById(R.id.buttonAdd);
            studentController = new StudentController(this);

            buttonAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String name = editTextName.getText().toString();
                    int age = Integer.parseInt(editTextAge.getText().toString());
                    studentController.addStudent(name, age);
                }
            });
        }

        public void showSuccessMessage() {
            Toast.makeText(this, "Étudiant ajouté avec succès", Toast.LENGTH_SHORT).show();
            // Réinitialiser les champs de saisie
            editTextName.setText("");
            editTextAge.setText("");
        }
    public class StudentController {
        private AddStudentActivity addStudentActivity;
        private List<Student> students;

        public StudentController(AddStudentActivity addStudentActivity) {
            this.addStudentActivity = addStudentActivity;
            this.students = new ArrayList<>();
        }

        public void addStudent(String name, int age) {
            Student student = new Student(name, age);
            students.add(student);
            addStudentActivity.showSuccessMessage();
        }
    }

