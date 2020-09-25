package com.mycodefu.betterfxml.records;

import javafx.beans.InvalidationListener;
import javafx.beans.NamedArg;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.util.Callback;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * TableView cell value factory supporting Java immutable Record type values.
 */
public class RecordValueFactory<S, T> implements Callback<CellDataFeatures<S, T>, ObservableValue<T>> {
    private final String property;
    private Class<?> columnClass;
    private Method method;

    public RecordValueFactory(@NamedArg("property") String property) {
        this.property = property;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ObservableValue<T> call(CellDataFeatures<S, T> param) {
        return getCellDataFromRecordReflectively(param.getValue());
    }

    public final String getProperty() {
        return property;
    }

    private ObservableValue<T> getCellDataFromRecordReflectively(S rowData) {
        if (getProperty() == null || getProperty().isEmpty() || rowData == null) return null;

        ObservableValue<T> result;
        try {
            if (columnClass == null) {
                this.columnClass = rowData.getClass();
            }
            if (this.method == null) {
                this.method = this.columnClass.getDeclaredMethod(getProperty());
            }
            result =  new SimpleValue<>((T) this.method.invoke(rowData));

        } catch (RuntimeException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
            result = null;
        }

        return result;
    }

    /**
     * Since the Record properties are immutable, there is never a case for them to change. no-op the change semantics.
     */
    public static class SimpleValue<T> implements ObservableValue<T> {
        private final T value;

        public SimpleValue(T value) {
            this.value = value;
        }

        @Override
        public T getValue() {
            return value;
        }

        @Override
        public void addListener(ChangeListener<? super T> listener) {}

        @Override
        public void removeListener(ChangeListener<? super T> listener) {}

        @Override
        public void addListener(InvalidationListener listener) {}

        @Override
        public void removeListener(InvalidationListener listener) {}
    }
}
