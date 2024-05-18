package com.example.study;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

// Implementor
interface OrganizationMethod {
    void organize();
}

// Concrete Implementations
class Textbook implements StudyMaterial {
    private OrganizationMethod organizationMethod;

    public Textbook(OrganizationMethod organizationMethod) {
        this.organizationMethod = organizationMethod;
    }

    @Override
    public void open() {
        System.out.println("Opening textbook...");
        organizationMethod.organize();
    }
}

class LectureSlides implements StudyMaterial {
    private OrganizationMethod organizationMethod;

    public LectureSlides(OrganizationMethod organizationMethod) {
        this.organizationMethod = organizationMethod;
    }

    @Override
    public void open() {
        System.out.println("Opening lecture slides...");
        organizationMethod.organize();
    }
}

class FolderOrganization implements OrganizationMethod {
    @Override
    public void organize() {
        System.out.println("Organizing in hierarchical folder structure...");
    }
}

class TaggingSystem implements OrganizationMethod {
    @Override
    public void organize() {
        System.out.println("Organizing using tagging system...");
    }
}

// Bridge
abstract class StudyMaterialBridge {
    protected OrganizationMethod organizationMethod;

    public StudyMaterialBridge(OrganizationMethod organizationMethod) {
        this.organizationMethod = organizationMethod;
    }

    public abstract void open();
}

class TextbookBridge extends StudyMaterialBridge {
    public TextbookBridge(OrganizationMethod organizationMethod) {
        super(organizationMethod);
    }

    @Override
    public void open() {
        System.out.println("Opening textbook...");
        organizationMethod.organize();
    }
}

class LectureSlidesBridge extends StudyMaterialBridge {
    public LectureSlidesBridge(OrganizationMethod organizationMethod) {
        super(organizationMethod);
    }

    @Override
    public void open() {
        System.out.println("Opening lecture slides...");
        organizationMethod.organize();
    }
}

public class StudyMaterialsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_materials);

        // Choose the organization method
        OrganizationMethod folderOrganization = new FolderOrganization();
        OrganizationMethod taggingSystem = new TaggingSystem();

        // Create study materials with different organization methods
        StudyMaterial textbook1 = new Textbook(new FolderOrganization());
        StudyMaterial textbook2 = new Textbook(new TaggingSystem());
        StudyMaterial lectureSlides1 = new LectureSlides(new FolderOrganization());
        StudyMaterial lectureSlides2 = new LectureSlides(new TaggingSystem());

        // Open study materials
        textbook1.open();
        textbook2.open();
        lectureSlides1.open();
        lectureSlides2.open();
    }
}
