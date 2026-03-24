package com.example.practicaexamen.controllers;

import com.example.practicaexamen.contactos.Contactos;
import com.example.practicaexamen.service.ContactosService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;

public class appController {
    @FXML
    private ListView<Contactos> listView;
    @FXML
    private Label lblMsg;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtTelefono;
    @FXML
    private ComboBox parentesco;
    @FXML
    private TextField txtBusqueda;

    @FXML
    private ContactosService logica = new ContactosService();

    @FXML
    public void initialize() {
        String[] opcionesParentesco = {"Padre", "Madre", "Hermano", "Hermana", "Abuelo", "Abuela", "Tío", "Tía"};
        parentesco.getItems().addAll(opcionesParentesco);
        listView.setItems(logica.obtenerLista());
        listView.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldValue, newValue) -> {
                    if (newValue != null) {
                        txtName.setText(newValue.getNombre());
                        txtTelefono.setText(newValue.getTelefono());
                        parentesco.setValue(newValue.getParentesco());
                    }
                }
        );
        txtBusqueda.textProperty().addListener((obs, old, newValue) -> {
            filterList(newValue);
        });
    }

    private void filterList(String dato) {
        if (dato == null || dato.isEmpty()) {
            listView.setItems(logica.obtenerLista());
            return;
        }

        ObservableList<Contactos> listaFiltrada = FXCollections.observableArrayList();
        String busqueda = dato.toLowerCase();

        for (Contactos item : logica.obtenerLista()) {
            if (item.getNombre().toLowerCase().contains(busqueda)) {
                listaFiltrada.add(item);
            }
        }
        listView.setItems(listaFiltrada);
    }
    @FXML
    public void onSearch(){
        txtBusqueda.textProperty().addListener((obs, old, newValue) -> {
            filterList(newValue);
        });
    }

    @FXML
    public void onAddPerson() {
        try {
            String nombre = txtName.getText();
            String telefono = txtTelefono.getText();
            String parentescoF = parentesco.getValue().toString();
            if (parentescoF == null) {
                throw new IllegalArgumentException("Debe seleccionar un parentesco de la lista.");
            }else if (logica.isDuplicate(nombre)){
                throw new IllegalArgumentException("El nombre no debe ser igual.");
            }else {
                logica.addContacto(nombre,telefono, parentescoF);
                loadFromFile();
                lblMsg.setText("Persona agregada con exito ");
                lblMsg.setStyle("-fx-text-fill: green");
                txtName.clear();
                txtTelefono.clear();
                parentesco.setValue(null);
            }
        }
        catch (IOException e) {
            lblMsg.setText("Hubo un error ");
            lblMsg.setStyle("-fx-text-fill: red");
        }
        catch (IllegalArgumentException e){
            lblMsg.setText("Hubo un error");
            lblMsg.setStyle("-fx-text-fill: red");
        }
    }

    @FXML
    public void onUpdate(){
        int index = listView.getSelectionModel().getSelectedIndex();
        String nombre = txtName.getText();
        String telefono = txtTelefono.getText();
        String parentescoF = parentesco.getSelectionModel().getSelectedItem().toString();
        try{
            logica.updatePerson(index, nombre, telefono, parentescoF);
            logica.validatePerson(nombre, telefono, parentescoF);
            loadFromFile();
            lblMsg.setText("Persona agregada con exito ");
            lblMsg.setStyle("-fx-text-fill: green");
            txtName.clear();
            txtTelefono.clear();
            parentesco.setValue(null);
        } catch (IllegalArgumentException ex){
            lblMsg.setText(ex.getMessage());
            lblMsg.setStyle("-fx-text-fill: red");
        }
    }
    @FXML
    public void onClean(){
        txtName.clear();
        txtTelefono.clear();
        parentesco.setValue(null);
    }

    @FXML
    public void onDelete(){
        int index = listView.getSelectionModel().getSelectedIndex();
        try{
            logica.deletContacto(index);
            loadFromFile();
            lblMsg.setText("Persona eliminada correctamente");
            lblMsg.setStyle("-fx-text-fill: green");
            txtName.clear();
            txtTelefono.clear();
            parentesco.setValue(null);
        }catch (IllegalArgumentException e){
            lblMsg.setText("Hubo un error en el archivo");
            lblMsg.setStyle("-fx-text-fill: red");
        }
    }

    public void onReload(){
        loadFromFile();
    }

    private void loadFromFile(){
        listView.setItems(logica.obtenerLista());

        lblMsg.setText("Lista actualizada");
        lblMsg.setStyle("-fx-text-fill: green");
    }

}
