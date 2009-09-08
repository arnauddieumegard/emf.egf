<?xml version="1.0" encoding="ASCII"?>
<ecore:EPackage xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:ecore="http://www.eclipse.org/emf/2002/Ecore" xmlns:egf.pattern="http://www.eclipse.org/egf/1.0.0/Pattern" name="pattern_1202377554488_149" nsURI="http://www.eclipse.org/egf/1.0.0/Pattern/Generated/Pattern.1202377554488.149" nsPrefix="pattern_1202377554488_149">
  <eClassifiers xsi:type="egf.pattern:Pattern" name="Pattern_1202377554488_149" id="EmfLibrary/Model/ClassLibrary/Pattern.1202377554488.149" logicalName="eIsSet_override" description="Emf pattern for eIsSet overriding point: eIsSet.override.javajetinc">
    <eAnnotations source="http://www.eclipse.org/egf/1.0.0/Pattern/production">
      <details key="Path" value="model/Class/eIsSet.override.javajetinc"/>
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
        <details key="body" value="READ(org.eclipse.egf.pattern.emf/templates/generated/Pattern.1202377554488.149/generatePreMatching.pt);"/>
      </eAnnotations>
      <eAnnotations source="http://www.eclipse.org/emf/2002/GenModel">
        <details key="body" value="StringBuilder builder = new StringBuilder();&#xA;builder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile(&quot;org.eclipse.egf.pattern.emf/templates/generated/Pattern.1202377554488.149/generatePreMatching.pt&quot;));&#xA;return builder.toString();&#xA;"/>
      </eAnnotations>
      <eType xsi:type="ecore:EDataType" href="http://www.eclipse.org/emf/2002/Ecore#//EString"/>
    </eOperations>
    <eOperations name="generatePostMatching">
      <eAnnotations source="http://www.eclipse.org/egf/1.0.0/Pattern">
        <details key="body" value="READ(org.eclipse.egf.pattern.emf/templates/generated/Pattern.1202377554488.149/generatePostMatching.pt);"/>
      </eAnnotations>
      <eAnnotations source="http://www.eclipse.org/emf/2002/GenModel">
        <details key="body" value="StringBuilder builder = new StringBuilder();&#xA;builder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile(&quot;org.eclipse.egf.pattern.emf/templates/generated/Pattern.1202377554488.149/generatePostMatching.pt&quot;));&#xA;return builder.toString();&#xA;"/>
      </eAnnotations>
      <eType xsi:type="ecore:EDataType" href="http://www.eclipse.org/emf/2002/Ecore#//EString"/>
    </eOperations>
    <eOperations name="generateHeader">
      <eAnnotations source="http://www.eclipse.org/egf/1.0.0/uid">
        <details key="body" value="PatternMethod.1202377554488.150"/>
      </eAnnotations>
      <eAnnotations source="http://www.eclipse.org/egf/1.0.0/Pattern">
        <details key="body" value="READ(org.eclipse.egf.pattern.emf/templates/Pattern.1202377554488.149/PatternMethod.1202377554488.150.pt);"/>
      </eAnnotations>
      <eAnnotations source="http://www.eclipse.org/emf/2002/GenModel">
        <details key="body" value="StringBuilder builder = new StringBuilder();&#xA;builder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile(&quot;org.eclipse.egf.pattern.emf/templates/Pattern.1202377554488.149/PatternMethod.1202377554488.150.pt&quot;));&#xA;return builder.toString();&#xA;"/>
      </eAnnotations>
      <eType xsi:type="ecore:EDataType" href="http://www.eclipse.org/emf/2002/Ecore#//EString"/>
    </eOperations>
    <eOperations name="generateFooter">
      <eAnnotations source="http://www.eclipse.org/egf/1.0.0/uid">
        <details key="body" value="PatternMethod.1202377554488.151"/>
      </eAnnotations>
      <eAnnotations source="http://www.eclipse.org/egf/1.0.0/Pattern">
        <details key="body" value="READ(org.eclipse.egf.pattern.emf/templates/Pattern.1202377554488.149/PatternMethod.1202377554488.151.pt);"/>
      </eAnnotations>
      <eAnnotations source="http://www.eclipse.org/emf/2002/GenModel">
        <details key="body" value="StringBuilder builder = new StringBuilder();&#xA;builder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile(&quot;org.eclipse.egf.pattern.emf/templates/Pattern.1202377554488.149/PatternMethod.1202377554488.151.pt&quot;));&#xA;return builder.toString();&#xA;"/>
      </eAnnotations>
      <eType xsi:type="ecore:EDataType" href="http://www.eclipse.org/emf/2002/Ecore#//EString"/>
    </eOperations>
  </eClassifiers>
</ecore:EPackage>
