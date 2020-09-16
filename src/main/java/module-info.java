module afterburnerfx {
	uses com.mycodefu.afterburner.injection.PresenterFactory;

	opens com.mycodefu.dashboard to javafx.fxml;
	opens com.mycodefu.dashboard.light to javafx.fxml;

	requires java.desktop;
	requires javafx.controls;
	requires javafx.fxml;
	requires javax.inject;

	exports com.mycodefu;
}