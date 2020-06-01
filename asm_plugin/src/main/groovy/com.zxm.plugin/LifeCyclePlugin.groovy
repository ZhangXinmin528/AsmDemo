package com.zxm.plugin

import com.android.build.gradle.AppExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

public class LifeCyclePlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        System.out.println("===LifeCyclePlugin==")

        def android = project.extensions.getByType(AppExtension)
        println '----------- registering AutoTrackTransform  -----------'
        LifeCycleTransform transform = new LifeCycleTransform()
        android.registerTransform(transform)
    }
}