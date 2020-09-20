open module afterburnerfx {
	uses com.mycodefu.afterburner.injection.PresenterFactory;

	requires java.desktop;
	requires javafx.controls;
	requires javafx.fxml;
	requires javax.inject;
	requires javafx.base;
	requires org.controlsfx.controls;

	exports com.mycodefu.dashboard.tables to org.controlsfx.controls;
}