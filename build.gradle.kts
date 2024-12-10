import korlibs.korge.gradle.*

plugins {
	alias(libs.plugins.korge)
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
}

korge {
	id = "com.jarungii.sagittariii"

// To enable all targets at once

	//targetAll()

// To enable targets based on properties/environment variables
	//targetDefault()

// To selectively enable targets
	
	targetJvm()
	targetAndroid()

	serializationJson()
}


dependencies {
    //implementation(libs.core)
    add("commonMainApi", project(":deps"))
    //add("commonMainApi", project(":korge-dragonbones"))
}

