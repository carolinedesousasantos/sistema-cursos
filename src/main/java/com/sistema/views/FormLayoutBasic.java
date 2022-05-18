package com.sistema.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.formlayout.FormLayout.ResponsiveStep;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("pessoa")
public class FormLayoutBasic extends Div {

    public FormLayoutBasic() {

        Select<String> tipoPessoa = new Select<>();
        tipoPessoa.setLabel("Tipo");
        tipoPessoa.setItems("ALUNO", "PROFESSOR");
        TextField firstName = new TextField("First name");
        TextField lastName = new TextField("Last name");

        Select<String> tipoDeDocumento = new Select<>();
        tipoDeDocumento.setLabel("Tipo de documento");
        tipoDeDocumento.setItems("RG", "CPF");

        TextField documento = new TextField("Número do documento");
        TextField telefone = new TextField("Número de telefone");

        Button primaryButton = new Button("Primary");
        primaryButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        FormLayout formLayout = new FormLayout();
        formLayout.add(
                tipoPessoa, firstName, lastName, tipoDeDocumento, documento, telefone, primaryButton
        );
        formLayout.setResponsiveSteps(
                // Use one column by default
                new ResponsiveStep("0", 1),
                // Use two columns, if layout's width exceeds 500px
                new ResponsiveStep("500px", 2)
        );
        // Stretch the username field over 2 columns


        add(formLayout);
    }
}