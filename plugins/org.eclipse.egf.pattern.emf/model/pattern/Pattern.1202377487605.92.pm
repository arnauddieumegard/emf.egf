<?xml version="1.0" encoding="ASCII"?>
<ecore:EPackage xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:ecore="http://www.eclipse.org/emf/2002/Ecore" xmlns:egf.pattern="http://www.eclipse.org/egf/1.0.0/Pattern" name="pattern_1202377487605_92" nsURI="http://www.eclipse.org/egf/1.0.0/Pattern/Generated/Pattern.1202377487605.92" nsPrefix="pattern_1202377487605_92">
  <eClassifiers xsi:type="egf.pattern:Pattern" name="Pattern_1202377487605_92" id="EmfLibrary/Model/ClassLibrary/Pattern.1202377487605.92" logicalName="basicUnsetGenFeature_annotations_insert" description="Emf pattern for basicUnsetGenFeature.annotations insertion point: basicUnsetGenFeature.annotations.insert.javajetinc">
    <eAnnotations source="http://www.eclipse.org/egf/1.0.0/Pattern/production">
      <details key="Path" value="model/Class/basicUnsetGenFeature.annotations.insert.javajetinc"/>
      <details key="Compilation" value="false"/>
      <details key="BufferModification" value="false"/>
    </eAnnotations>
    <eSuperTypes href="../../../../plugin/org.eclipse.egf.model/model/pattern.ecore#//Pattern"/>
    <eOperations name="generateBody">
      <eType xsi:type="ecore:EDataType" href="http://www.eclipse.org/emf/2002/Ecore#//EString"/>
      <eParameters name="classLoader_p">
        <eType xsi:type="ecore:EDataType" href="http://www.eclipse.org/emf/2002/Ecore#//EJavaObject"/>
      </eParameters>
    </eOperations>
    <eOperations name="generatePreMatching">
      <eAnnotations source="http://www.eclipse.org/egf/1.0.0/Pattern">
        <details key="body" value="READ(org.eclipse.egf.pattern.emf/templates/generated/Pattern.1202377487605.92/generatePreMatching.pt);"/>
      </eAnnotations>
      <eAnnotations source="http://www.eclipse.org/emf/2002/GenModel">
        <details key="body" value="StringBuilder builder = new StringBuilder();&#xA;builder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile(&quot;org.eclipse.egf.pattern.emf/templates/generated/Pattern.1202377487605.92/generatePreMatching.pt&quot;));&#xA;return builder.toString();&#xA;"/>
      </eAnnotations>
      <eType xsi:type="ecore:EDataType" href="http://www.eclipse.org/emf/2002/Ecore#//EString"/>
    </eOperations>
    <eOperations name="generatePostMatching">
      <eAnnotations source="http://www.eclipse.org/egf/1.0.0/Pattern">
        <details key="body" value="READ(org.eclipse.egf.pattern.emf/templates/generated/Pattern.1202377487605.92/generatePostMatching.pt);"/>
      </eAnnotations>
      <eAnnotations source="http://www.eclipse.org/emf/2002/GenModel">
        <details key="body" value="StringBuilder builder = new StringBuilder();&#xA;builder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile(&quot;org.eclipse.egf.pattern.emf/templates/generated/Pattern.1202377487605.92/generatePostMatching.pt&quot;));&#xA;return builder.toString();&#xA;"/>
      </eAnnotations>
      <eType xsi:type="ecore:EDataType" href="http://www.eclipse.org/emf/2002/Ecore#//EString"/>
    </eOperations>
    <eOperations name="generateHeader">
      <eAnnotations source="http://www.eclipse.org/egf/1.0.0/uid">
        <details key="body" value="PatternMethod.1202377487605.93"/>
      </eAnnotations>
      <eAnnotations source="http://www.eclipse.org/egf/1.0.0/Pattern">
        <details key="body" value="READ(org.eclipse.egf.pattern.emf/templates/Pattern.1202377487605.92/PatternMethod.1202377487605.93.pt);"/>
      </eAnnotations>
      <eAnnotations source="http://www.eclipse.org/emf/2002/GenModel">
        <details key="body" value="StringBuilder builder = new StringBuilder();&#xA;builder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile(&quot;org.eclipse.egf.pattern.emf/templates/Pattern.1202377487605.92/PatternMethod.1202377487605.93.pt&quot;));&#xA;return builder.toString();&#xA;"/>
      </eAnnotations>
      <eType xsi:type="ecore:EDataType" href="http://www.eclipse.org/emf/2002/Ecore#//EString"/>
    </eOperations>
    <eOperations name="generateFooter">
      <eAnnotations source="http://www.eclipse.org/egf/1.0.0/uid">
        <details key="body" value="PatternMethod.1202377487605.94"/>
      </eAnnotations>
      <eAnnotations source="http://www.eclipse.org/egf/1.0.0/Pattern">
        <details key="body" value="READ(org.eclipse.egf.pattern.emf/templates/Pattern.1202377487605.92/PatternMethod.1202377487605.94.pt);"/>
      </eAnnotations>
      <eAnnotations source="http://www.eclipse.org/emf/2002/GenModel">
        <details key="body" value="StringBuilder builder = new StringBuilder();&#xA;builder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile(&quot;org.eclipse.egf.pattern.emf/templates/Pattern.1202377487605.92/PatternMethod.1202377487605.94.pt&quot;));&#xA;return builder.toString();&#xA;"/>
      </eAnnotations>
      <eType xsi:type="ecore:EDataType" href="http://www.eclipse.org/emf/2002/Ecore#//EString"/>
    </eOperations>
  </eClassifiers>
</ecore:EPackage>
