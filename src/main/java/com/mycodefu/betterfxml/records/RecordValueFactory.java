package com.mycodefu.betterfxml.records;

import javafx.beans.InvalidationListener;
import javafx.beans.NamedArg;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.util.Callback;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * TableView cell value factory supporting Java immutable Record type values.
 */
public class RecordValueFactory<S, T> implements Callback<CellDataFeatures<S, T>, ObservableValue<T>> {
    private Class<?> columnClass;
    private java.lang.invoke.MethodHandle method;

    /**
     * {@inheritDoc}
     */
    @Override
    public ObservableValue<T> call(CellDataFeatures<S, T> param) {
        return getCellDataFromRecordReflectively(param.getTableColumn().getId(), param.getValue());
    }

    private ObservableValue<T> getCellDataFromRecordReflectively(String id, S rowData) {
        if (id == null || id.isEmpty() || rowData == null) return null;

        if (id.endsWith("Column")) {
            id = id.substring(0, "Column".length());
        }

        ObservableValue<T> result;
        try {
            if (columnClass == null) {
                this.columnClass = rowData.getClass();
            }
            if (this.method == null) {
                this.method = MethodHandles.lookup().unreflect(this.columnClass.getDeclaredMethod(id));
            }

            T value = (T) this.method.invoke(rowData);

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
