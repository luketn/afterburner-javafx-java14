package com.mycodefu.betterfxml.records;

import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.util.Callback;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Method;

/**
 * TableView cell value factory supporting Java immutable Record type values.
 */
public class RecordValueFactory<S, T> implements Callback<CellDataFeatures<S, T>, ObservableValue<T>> {
    private MethodHandle methodHandle;

    @Override
    public ObservableValue<T> call(CellDataFeatures<S, T> param) {
        String id = param.getTableColumn().getId();
        S rowData = param.getValue();

        if (id == null || id.isEmpty() || rowData == null) return null;

        if (id.endsWith("Column")) {
            id = id.substring(0, "Column".length());
        }

        ObservableValue<T> result;
        try {
            if (this.methodHandle == null) {
                Class<?> columnClass = rowData.getClass();
                Method declaredMethod = columnClass.getDeclaredMethod(id);
                MethodHandle methodHandle = MethodHandles.lookup().unreflect(declaredMethod);

                this.methodHandle = methodHandle;
            }

            T value = (T) this.methodHandle.invoke(rowData);

            result =  new SimpleValue<>(value);

        } catch (Throwable e) {
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
