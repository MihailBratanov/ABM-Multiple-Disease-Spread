package abm_multiple_disease_spread;

import static abm_multiple_disease_spread.SocialActivity.*;
import static com.xj.anylogic.engine.HyperArray.*;
import static com.xj.anylogic.engine.UtilitiesArray.*;
import static com.xj.anylogic.engine.presentation.UtilitiesColor.*;
import static com.xj.anylogic.engine.presentation.UtilitiesDrawing.*;
import static java.lang.Math.*;

import com.xj.anylogic.engine.*;
import com.xj.anylogic.engine.Position;
import com.xj.anylogic.engine.analysis.*;
import com.xj.anylogic.engine.connectivity.*;
import com.xj.anylogic.engine.connectivity.ResultSet;
import com.xj.anylogic.engine.connectivity.Statement;
import com.xj.anylogic.engine.markup.*;
import com.xj.anylogic.engine.markup.DensityMap;
import com.xj.anylogic.engine.markup.Network;
import com.xj.anylogic.engine.markup.PedFlowStatistics;
import com.xj.anylogic.engine.presentation.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Arc2D;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Currency;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.Stack;
import java.util.Timer;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

public class Person extends Agent {

  // Parameters

  public Home agentHome;

  /**
   * Returns default value for parameter <code>agentHome</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public Home _agentHome_DefaultValue_xjal() {
    final Person self = this;
    return null;
  }

  public void set_agentHome(Home agentHome) {
    if (agentHome == this.agentHome) {
      return;
    }
    Home _oldValue_xjal = this.agentHome;
    this.agentHome = agentHome;
    onChange_agentHome_xjal(_oldValue_xjal);
    onChange();
  }

  /**
   * Calls "On change" action for parameter agentHome.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_agentHome()</code> method instead.
   */
  void onChange_agentHome() {
    onChange_agentHome_xjal(agentHome);
  }

  @AnyLogicInternalCodegenAPI
  void onChange_agentHome_xjal(Home oldValue) {}

  public School agentSchool;

  /**
   * Returns default value for parameter <code>agentSchool</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public School _agentSchool_DefaultValue_xjal() {
    final Person self = this;
    return null;
  }

  public void set_agentSchool(School agentSchool) {
    if (agentSchool == this.agentSchool) {
      return;
    }
    School _oldValue_xjal = this.agentSchool;
    this.agentSchool = agentSchool;
    onChange_agentSchool_xjal(_oldValue_xjal);
    onChange();
  }

  /**
   * Calls "On change" action for parameter agentSchool.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_agentSchool()</code> method instead.
   */
  void onChange_agentSchool() {
    onChange_agentSchool_xjal(agentSchool);
  }

  @AnyLogicInternalCodegenAPI
  void onChange_agentSchool_xjal(School oldValue) {}

  public Workplace agentWorkplace;

  /**
   * Returns default value for parameter <code>agentWorkplace</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public Workplace _agentWorkplace_DefaultValue_xjal() {
    final Person self = this;
    return null;
  }

  public void set_agentWorkplace(Workplace agentWorkplace) {
    if (agentWorkplace == this.agentWorkplace) {
      return;
    }
    Workplace _oldValue_xjal = this.agentWorkplace;
    this.agentWorkplace = agentWorkplace;
    onChange_agentWorkplace_xjal(_oldValue_xjal);
    onChange();
  }

  /**
   * Calls "On change" action for parameter agentWorkplace.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_agentWorkplace()</code> method instead.
   */
  void onChange_agentWorkplace() {
    onChange_agentWorkplace_xjal(agentWorkplace);
  }

  @AnyLogicInternalCodegenAPI
  void onChange_agentWorkplace_xjal(Workplace oldValue) {}

  public int agentAge;

  /**
   * Returns default value for parameter <code>agentAge</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public int _agentAge_DefaultValue_xjal() {
    final Person self = this;
    return 0;
  }

  public void set_agentAge(int agentAge) {
    if (agentAge == this.agentAge) {
      return;
    }
    int _oldValue_xjal = this.agentAge;
    this.agentAge = agentAge;
    onChange_agentAge_xjal(_oldValue_xjal);
    onChange();
  }

  /**
   * Calls "On change" action for parameter agentAge.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_agentAge()</code> method instead.
   */
  void onChange_agentAge() {
    onChange_agentAge_xjal(agentAge);
  }

  @AnyLogicInternalCodegenAPI
  void onChange_agentAge_xjal(int oldValue) {}

  public SocialActivity socialActivityStyle;

  /**
   * Returns default value for parameter <code>socialActivityStyle</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public SocialActivity _socialActivityStyle_DefaultValue_xjal() {
    final Person self = this;
    return MoreThanOnceWeekly;
  }

  public void set_socialActivityStyle(SocialActivity socialActivityStyle) {
    if (socialActivityStyle == this.socialActivityStyle) {
      return;
    }
    SocialActivity _oldValue_xjal = this.socialActivityStyle;
    this.socialActivityStyle = socialActivityStyle;
    onChange_socialActivityStyle_xjal(_oldValue_xjal);
    onChange();
  }

  /**
   * Calls "On change" action for parameter socialActivityStyle.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_socialActivityStyle()</code> method instead.
   */
  void onChange_socialActivityStyle() {
    onChange_socialActivityStyle_xjal(socialActivityStyle);
  }

  @AnyLogicInternalCodegenAPI
  void onChange_socialActivityStyle_xjal(SocialActivity oldValue) {}

  public boolean isAvailable;

  /**
   * Returns default value for parameter <code>isAvailable</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public boolean _isAvailable_DefaultValue_xjal() {
    final Person self = this;
    return true;
  }

  public void set_isAvailable(boolean isAvailable) {
    if (isAvailable == this.isAvailable) {
      return;
    }
    boolean _oldValue_xjal = this.isAvailable;
    this.isAvailable = isAvailable;
    onChange_isAvailable_xjal(_oldValue_xjal);
    onChange();
  }

  /**
   * Calls "On change" action for parameter isAvailable.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_isAvailable()</code> method instead.
   */
  void onChange_isAvailable() {
    onChange_isAvailable_xjal(isAvailable);
  }

  @AnyLogicInternalCodegenAPI
  void onChange_isAvailable_xjal(boolean oldValue) {}

  public int numFriends;

  /**
   * Returns default value for parameter <code>numFriends</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public int _numFriends_DefaultValue_xjal() {
    final Person self = this;
    return 1;
  }

  public void set_numFriends(int numFriends) {
    if (numFriends == this.numFriends) {
      return;
    }
    int _oldValue_xjal = this.numFriends;
    this.numFriends = numFriends;
    onChange_numFriends_xjal(_oldValue_xjal);
    onChange();
  }

  /**
   * Calls "On change" action for parameter numFriends.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_numFriends()</code> method instead.
   */
  void onChange_numFriends() {
    onChange_numFriends_xjal(numFriends);
  }

  @AnyLogicInternalCodegenAPI
  void onChange_numFriends_xjal(int oldValue) {}

  public double covidInfectionProbability;

  /**
   * Returns default value for parameter <code>covidInfectionProbability</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _covidInfectionProbability_DefaultValue_xjal() {
    final Person self = this;
    return 0.1;
  }

  public void set_covidInfectionProbability(double covidInfectionProbability) {
    if (covidInfectionProbability == this.covidInfectionProbability) {
      return;
    }
    double _oldValue_xjal = this.covidInfectionProbability;
    this.covidInfectionProbability = covidInfectionProbability;
    onChange_covidInfectionProbability_xjal(_oldValue_xjal);
    onChange();
  }

  /**
   * Calls "On change" action for parameter covidInfectionProbability.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_covidInfectionProbability()</code> method instead.
   */
  void onChange_covidInfectionProbability() {
    onChange_covidInfectionProbability_xjal(covidInfectionProbability);
  }

  @AnyLogicInternalCodegenAPI
  void onChange_covidInfectionProbability_xjal(double oldValue) {}

  public double covidClinicalRate;

  /**
   * Returns default value for parameter <code>covidClinicalRate</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _covidClinicalRate_DefaultValue_xjal() {
    final Person self = this;
    return calculateCovidClinicalRate(agentAge);
  }

  public void set_covidClinicalRate(double covidClinicalRate) {
    if (covidClinicalRate == this.covidClinicalRate) {
      return;
    }
    double _oldValue_xjal = this.covidClinicalRate;
    this.covidClinicalRate = covidClinicalRate;
    onChange_covidClinicalRate_xjal(_oldValue_xjal);
    onChange();
  }

  /**
   * Calls "On change" action for parameter covidClinicalRate.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_covidClinicalRate()</code> method instead.
   */
  void onChange_covidClinicalRate() {
    onChange_covidClinicalRate_xjal(covidClinicalRate);
  }

  @AnyLogicInternalCodegenAPI
  void onChange_covidClinicalRate_xjal(double oldValue) {}

  public double covidICURate;

  /**
   * Returns default value for parameter <code>covidICURate</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _covidICURate_DefaultValue_xjal() {
    final Person self = this;
    return calculateCovidICURate(agentAge);
  }

  public void set_covidICURate(double covidICURate) {
    if (covidICURate == this.covidICURate) {
      return;
    }
    double _oldValue_xjal = this.covidICURate;
    this.covidICURate = covidICURate;
    onChange_covidICURate_xjal(_oldValue_xjal);
    onChange();
  }

  /**
   * Calls "On change" action for parameter covidICURate.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_covidICURate()</code> method instead.
   */
  void onChange_covidICURate() {
    onChange_covidICURate_xjal(covidICURate);
  }

  @AnyLogicInternalCodegenAPI
  void onChange_covidICURate_xjal(double oldValue) {}

  public double fluInfectionProbability;

  /**
   * Returns default value for parameter <code>fluInfectionProbability</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _fluInfectionProbability_DefaultValue_xjal() {
    final Person self = this;
    return 0.1;
  }

  public void set_fluInfectionProbability(double fluInfectionProbability) {
    if (fluInfectionProbability == this.fluInfectionProbability) {
      return;
    }
    double _oldValue_xjal = this.fluInfectionProbability;
    this.fluInfectionProbability = fluInfectionProbability;
    onChange_fluInfectionProbability_xjal(_oldValue_xjal);
    onChange();
  }

  /**
   * Calls "On change" action for parameter fluInfectionProbability.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_fluInfectionProbability()</code> method instead.
   */
  void onChange_fluInfectionProbability() {
    onChange_fluInfectionProbability_xjal(fluInfectionProbability);
  }

  @AnyLogicInternalCodegenAPI
  void onChange_fluInfectionProbability_xjal(double oldValue) {}

  public boolean atRiskFromCovid;

  /**
   * Returns default value for parameter <code>atRiskFromCovid</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public boolean _atRiskFromCovid_DefaultValue_xjal() {
    final Person self = this;
    return randomTrue(covidChronicRisk);
  }

  public void set_atRiskFromCovid(boolean atRiskFromCovid) {
    if (atRiskFromCovid == this.atRiskFromCovid) {
      return;
    }
    boolean _oldValue_xjal = this.atRiskFromCovid;
    this.atRiskFromCovid = atRiskFromCovid;
    onChange_atRiskFromCovid_xjal(_oldValue_xjal);
    onChange();
  }

  /**
   * Calls "On change" action for parameter atRiskFromCovid.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_atRiskFromCovid()</code> method instead.
   */
  void onChange_atRiskFromCovid() {
    onChange_atRiskFromCovid_xjal(atRiskFromCovid);
  }

  @AnyLogicInternalCodegenAPI
  void onChange_atRiskFromCovid_xjal(boolean oldValue) {}

  public double covidChronicRisk;

  /**
   * Returns default value for parameter <code>covidChronicRisk</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _covidChronicRisk_DefaultValue_xjal() {
    final Person self = this;
    return calculateChronicRiskCovid();
  }

  public void set_covidChronicRisk(double covidChronicRisk) {
    if (covidChronicRisk == this.covidChronicRisk) {
      return;
    }
    double _oldValue_xjal = this.covidChronicRisk;
    this.covidChronicRisk = covidChronicRisk;
    onChange_covidChronicRisk_xjal(_oldValue_xjal);
    onChange();
  }

  /**
   * Calls "On change" action for parameter covidChronicRisk.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_covidChronicRisk()</code> method instead.
   */
  void onChange_covidChronicRisk() {
    onChange_covidChronicRisk_xjal(covidChronicRisk);
  }

  @AnyLogicInternalCodegenAPI
  void onChange_covidChronicRisk_xjal(double oldValue) {}

  public double fluClinicalRate;

  /**
   * Returns default value for parameter <code>fluClinicalRate</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _fluClinicalRate_DefaultValue_xjal() {
    final Person self = this;
    return calculateFluClinicalRate(agentAge);
  }

  public void set_fluClinicalRate(double fluClinicalRate) {
    if (fluClinicalRate == this.fluClinicalRate) {
      return;
    }
    double _oldValue_xjal = this.fluClinicalRate;
    this.fluClinicalRate = fluClinicalRate;
    onChange_fluClinicalRate_xjal(_oldValue_xjal);
    onChange();
  }

  /**
   * Calls "On change" action for parameter fluClinicalRate.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_fluClinicalRate()</code> method instead.
   */
  void onChange_fluClinicalRate() {
    onChange_fluClinicalRate_xjal(fluClinicalRate);
  }

  @AnyLogicInternalCodegenAPI
  void onChange_fluClinicalRate_xjal(double oldValue) {}

  public boolean atRiskFromFlu;

  /**
   * Returns default value for parameter <code>atRiskFromFlu</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public boolean _atRiskFromFlu_DefaultValue_xjal() {
    final Person self = this;
    return randomTrue(fluChronicRisk);
  }

  public void set_atRiskFromFlu(boolean atRiskFromFlu) {
    if (atRiskFromFlu == this.atRiskFromFlu) {
      return;
    }
    boolean _oldValue_xjal = this.atRiskFromFlu;
    this.atRiskFromFlu = atRiskFromFlu;
    onChange_atRiskFromFlu_xjal(_oldValue_xjal);
    onChange();
  }

  /**
   * Calls "On change" action for parameter atRiskFromFlu.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_atRiskFromFlu()</code> method instead.
   */
  void onChange_atRiskFromFlu() {
    onChange_atRiskFromFlu_xjal(atRiskFromFlu);
  }

  @AnyLogicInternalCodegenAPI
  void onChange_atRiskFromFlu_xjal(boolean oldValue) {}

  public double fluChronicRisk;

  /**
   * Returns default value for parameter <code>fluChronicRisk</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _fluChronicRisk_DefaultValue_xjal() {
    final Person self = this;
    return calculateChronicRiskFlu();
  }

  public void set_fluChronicRisk(double fluChronicRisk) {
    if (fluChronicRisk == this.fluChronicRisk) {
      return;
    }
    double _oldValue_xjal = this.fluChronicRisk;
    this.fluChronicRisk = fluChronicRisk;
    onChange_fluChronicRisk_xjal(_oldValue_xjal);
    onChange();
  }

  /**
   * Calls "On change" action for parameter fluChronicRisk.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_fluChronicRisk()</code> method instead.
   */
  void onChange_fluChronicRisk() {
    onChange_fluChronicRisk_xjal(fluChronicRisk);
  }

  @AnyLogicInternalCodegenAPI
  void onChange_fluChronicRisk_xjal(double oldValue) {}

  public double fluICURate;

  /**
   * Returns default value for parameter <code>fluICURate</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _fluICURate_DefaultValue_xjal() {
    final Person self = this;
    return calculateFluICURate(agentAge);
  }

  public void set_fluICURate(double fluICURate) {
    if (fluICURate == this.fluICURate) {
      return;
    }
    double _oldValue_xjal = this.fluICURate;
    this.fluICURate = fluICURate;
    onChange_fluICURate_xjal(_oldValue_xjal);
    onChange();
  }

  /**
   * Calls "On change" action for parameter fluICURate.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_fluICURate()</code> method instead.
   */
  void onChange_fluICURate() {
    onChange_fluICURate_xjal(fluICURate);
  }

  @AnyLogicInternalCodegenAPI
  void onChange_fluICURate_xjal(double oldValue) {}

  public double fluDangerFactor;

  /**
   * Returns default value for parameter <code>fluDangerFactor</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _fluDangerFactor_DefaultValue_xjal() {
    final Person self = this;
    return calculateFluDangerFactor(agentAge);
  }

  public void set_fluDangerFactor(double fluDangerFactor) {
    if (fluDangerFactor == this.fluDangerFactor) {
      return;
    }
    double _oldValue_xjal = this.fluDangerFactor;
    this.fluDangerFactor = fluDangerFactor;
    onChange_fluDangerFactor_xjal(_oldValue_xjal);
    onChange();
  }

  /**
   * Calls "On change" action for parameter fluDangerFactor.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_fluDangerFactor()</code> method instead.
   */
  void onChange_fluDangerFactor() {
    onChange_fluDangerFactor_xjal(fluDangerFactor);
  }

  @AnyLogicInternalCodegenAPI
  void onChange_fluDangerFactor_xjal(double oldValue) {}

  public double covidDangerFactor;

  /**
   * Returns default value for parameter <code>covidDangerFactor</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _covidDangerFactor_DefaultValue_xjal() {
    final Person self = this;
    return calculateCovidMortalityRate(agentAge);
  }

  public void set_covidDangerFactor(double covidDangerFactor) {
    if (covidDangerFactor == this.covidDangerFactor) {
      return;
    }
    double _oldValue_xjal = this.covidDangerFactor;
    this.covidDangerFactor = covidDangerFactor;
    onChange_covidDangerFactor_xjal(_oldValue_xjal);
    onChange();
  }

  /**
   * Calls "On change" action for parameter covidDangerFactor.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_covidDangerFactor()</code> method instead.
   */
  void onChange_covidDangerFactor() {
    onChange_covidDangerFactor_xjal(covidDangerFactor);
  }

  @AnyLogicInternalCodegenAPI
  void onChange_covidDangerFactor_xjal(double oldValue) {}

  @Override
  public void setParametersToDefaultValues() {
    super.setParametersToDefaultValues();
    agentHome = _agentHome_DefaultValue_xjal();
    agentSchool = _agentSchool_DefaultValue_xjal();
    agentWorkplace = _agentWorkplace_DefaultValue_xjal();
    agentAge = _agentAge_DefaultValue_xjal();
    socialActivityStyle = _socialActivityStyle_DefaultValue_xjal();
    isAvailable = _isAvailable_DefaultValue_xjal();
    numFriends = _numFriends_DefaultValue_xjal();
    covidInfectionProbability = _covidInfectionProbability_DefaultValue_xjal();
    covidClinicalRate = _covidClinicalRate_DefaultValue_xjal();
    covidICURate = _covidICURate_DefaultValue_xjal();
    fluInfectionProbability = _fluInfectionProbability_DefaultValue_xjal();
    atRiskFromCovid = _atRiskFromCovid_DefaultValue_xjal();
    covidChronicRisk = _covidChronicRisk_DefaultValue_xjal();
    fluClinicalRate = _fluClinicalRate_DefaultValue_xjal();
    atRiskFromFlu = _atRiskFromFlu_DefaultValue_xjal();
    fluChronicRisk = _fluChronicRisk_DefaultValue_xjal();
    fluICURate = _fluICURate_DefaultValue_xjal();
    fluDangerFactor = _fluDangerFactor_DefaultValue_xjal();
    covidDangerFactor = _covidDangerFactor_DefaultValue_xjal();
  }

  @Override
  public boolean setParameter(
    String _name_xjal,
    Object _value_xjal,
    boolean _callOnChange_xjal
  ) {
    if ("agentHome".equals(_name_xjal)) {
      if (_callOnChange_xjal) {
        set_agentHome((Home) _value_xjal);
      } else {
        agentHome = (Home) _value_xjal;
      }
      return true;
    }
    if ("agentSchool".equals(_name_xjal)) {
      if (_callOnChange_xjal) {
        set_agentSchool((School) _value_xjal);
      } else {
        agentSchool = (School) _value_xjal;
      }
      return true;
    }
    if ("agentWorkplace".equals(_name_xjal)) {
      if (_callOnChange_xjal) {
        set_agentWorkplace((Workplace) _value_xjal);
      } else {
        agentWorkplace = (Workplace) _value_xjal;
      }
      return true;
    }
    if ("agentAge".equals(_name_xjal)) {
      if (_callOnChange_xjal) {
        set_agentAge(((Number) _value_xjal).intValue());
      } else {
        agentAge = ((Number) _value_xjal).intValue();
      }
      return true;
    }
    if ("socialActivityStyle".equals(_name_xjal)) {
      if (_callOnChange_xjal) {
        set_socialActivityStyle((SocialActivity) _value_xjal);
      } else {
        socialActivityStyle = (SocialActivity) _value_xjal;
      }
      return true;
    }
    if ("isAvailable".equals(_name_xjal)) {
      if (_callOnChange_xjal) {
        set_isAvailable((Boolean) _value_xjal);
      } else {
        isAvailable = (Boolean) _value_xjal;
      }
      return true;
    }
    if ("numFriends".equals(_name_xjal)) {
      if (_callOnChange_xjal) {
        set_numFriends(((Number) _value_xjal).intValue());
      } else {
        numFriends = ((Number) _value_xjal).intValue();
      }
      return true;
    }
    if ("covidInfectionProbability".equals(_name_xjal)) {
      if (_callOnChange_xjal) {
        set_covidInfectionProbability(((Number) _value_xjal).doubleValue());
      } else {
        covidInfectionProbability = ((Number) _value_xjal).doubleValue();
      }
      return true;
    }
    if ("covidClinicalRate".equals(_name_xjal)) {
      if (_callOnChange_xjal) {
        set_covidClinicalRate(((Number) _value_xjal).doubleValue());
      } else {
        covidClinicalRate = ((Number) _value_xjal).doubleValue();
      }
      return true;
    }
    if ("covidICURate".equals(_name_xjal)) {
      if (_callOnChange_xjal) {
        set_covidICURate(((Number) _value_xjal).doubleValue());
      } else {
        covidICURate = ((Number) _value_xjal).doubleValue();
      }
      return true;
    }
    if ("fluInfectionProbability".equals(_name_xjal)) {
      if (_callOnChange_xjal) {
        set_fluInfectionProbability(((Number) _value_xjal).doubleValue());
      } else {
        fluInfectionProbability = ((Number) _value_xjal).doubleValue();
      }
      return true;
    }
    if ("atRiskFromCovid".equals(_name_xjal)) {
      if (_callOnChange_xjal) {
        set_atRiskFromCovid((Boolean) _value_xjal);
      } else {
        atRiskFromCovid = (Boolean) _value_xjal;
      }
      return true;
    }
    if ("covidChronicRisk".equals(_name_xjal)) {
      if (_callOnChange_xjal) {
        set_covidChronicRisk(((Number) _value_xjal).doubleValue());
      } else {
        covidChronicRisk = ((Number) _value_xjal).doubleValue();
      }
      return true;
    }
    if ("fluClinicalRate".equals(_name_xjal)) {
      if (_callOnChange_xjal) {
        set_fluClinicalRate(((Number) _value_xjal).doubleValue());
      } else {
        fluClinicalRate = ((Number) _value_xjal).doubleValue();
      }
      return true;
    }
    if ("atRiskFromFlu".equals(_name_xjal)) {
      if (_callOnChange_xjal) {
        set_atRiskFromFlu((Boolean) _value_xjal);
      } else {
        atRiskFromFlu = (Boolean) _value_xjal;
      }
      return true;
    }
    if ("fluChronicRisk".equals(_name_xjal)) {
      if (_callOnChange_xjal) {
        set_fluChronicRisk(((Number) _value_xjal).doubleValue());
      } else {
        fluChronicRisk = ((Number) _value_xjal).doubleValue();
      }
      return true;
    }
    if ("fluICURate".equals(_name_xjal)) {
      if (_callOnChange_xjal) {
        set_fluICURate(((Number) _value_xjal).doubleValue());
      } else {
        fluICURate = ((Number) _value_xjal).doubleValue();
      }
      return true;
    }
    if ("fluDangerFactor".equals(_name_xjal)) {
      if (_callOnChange_xjal) {
        set_fluDangerFactor(((Number) _value_xjal).doubleValue());
      } else {
        fluDangerFactor = ((Number) _value_xjal).doubleValue();
      }
      return true;
    }
    if ("covidDangerFactor".equals(_name_xjal)) {
      if (_callOnChange_xjal) {
        set_covidDangerFactor(((Number) _value_xjal).doubleValue());
      } else {
        covidDangerFactor = ((Number) _value_xjal).doubleValue();
      }
      return true;
    }
    return super.setParameter(_name_xjal, _value_xjal, _callOnChange_xjal);
  }

  // Plain Variables

  public SocialPlace agentMarket;
  public Hospital nearestHospital;
  public int numMeetings;
  public boolean hasMeeting;
  public boolean hospitalizedFlu;
  public double contactRate;
  public double factor;
  public boolean hospitalizedCovid;
  public boolean canMeet;
  public double maskFactor;

  // Collection Variables
  public java.util.ArrayList<Person> friendContacts = new java.util.ArrayList<Person>();
  public java.util.ArrayList<Person> infectionGroup = new java.util.ArrayList<Person>();
  public java.util.ArrayList<Integer> meetingSchedule = new java.util.ArrayList<Integer>();
  // Events

  public EventTimeout update_schedule = new EventTimeout(this);
  public EventTimeout has_meeting = new EventTimeout(this);
  public EventTimeout morning = new EventTimeout(this);
  public EventTimeout endOfWorkDay = new EventTimeout(this);
  public EventTimeout meetingOver = new EventTimeout(this);
  public EventTimeout meeting = new EventTimeout(this);

  @Override
  @AnyLogicInternalCodegenAPI
  public String getNameOf(EventTimeout _e) {
    if (_e == update_schedule) return "update_schedule";
    if (_e == has_meeting) return "has_meeting";
    if (_e == morning) return "morning";
    if (_e == endOfWorkDay) return "endOfWorkDay";
    if (_e == meetingOver) return "meetingOver";
    if (_e == meeting) return "meeting";
    return super.getNameOf(_e);
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public EventTimeout.Mode getModeOf(EventTimeout _e) {
    if (_e == update_schedule) return EVENT_TIMEOUT_MODE_CYCLIC;
    if (_e == has_meeting) return EVENT_TIMEOUT_MODE_CYCLIC;
    if (_e == morning) return EVENT_TIMEOUT_MODE_CYCLIC;
    if (_e == endOfWorkDay) return EVENT_TIMEOUT_MODE_CYCLIC;
    if (_e == meetingOver) return EVENT_TIMEOUT_MODE_CYCLIC;
    if (_e == meeting) return EVENT_TIMEOUT_MODE_CYCLIC;
    return super.getModeOf(_e);
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public double getFirstOccurrenceTime(EventTimeout _e) {
    if (_e == update_schedule) return 0;
    if (_e == has_meeting) return 0;
    if (_e == morning) return 0.33;
    if (_e == endOfWorkDay) return 0.85;
    if (_e == meetingOver) return 0.65;
    if (_e == meeting) return 0.5;
    return super.getFirstOccurrenceTime(_e);
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public double evaluateTimeoutOf(EventTimeout _e) {
    if (_e == update_schedule) {
      double _t = 1;
      return _t * week();
    }
    if (_e == has_meeting) {
      double _t = 1;
      return _t * day();
    }
    if (_e == morning) {
      double _t = 1;
      return _t * day();
    }
    if (_e == endOfWorkDay) {
      double _t = 1;
      return _t * day();
    }
    if (_e == meetingOver) {
      double _t = 1;
      return _t * day();
    }
    if (_e == meeting) {
      double _t = 1;
      return _t * day();
    }
    return super.evaluateTimeoutOf(_e);
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void executeActionOf(EventTimeout _e) {
    if (_e == update_schedule) {
      EventTimeout self = _e;

      this.meetingSchedule.removeAll(meetingSchedule);
      create_schedule(this.numMeetings);
      return;
    }
    if (_e == has_meeting) {
      EventTimeout self = _e;

      if (meetingSchedule.contains(this.getEngine().getDayOfWeek())) {
        hasMeeting = true;
        isAvailable = false;
      } else if (
        socialActivityStyle == OnceMonthly &&
        meetingSchedule.contains(this.getEngine().getDayOfMonth())
      ) {
        hasMeeting = true;
        isAvailable = false;
      } else {
        hasMeeting = false;
        isAvailable = true;
      }
      return;
    }
    if (_e == morning) {
      EventTimeout self = _e;

      //in the morning if the person does not have symptoms, he goes to work
      if (
        (
          covid_progression.getActiveSimpleState() == ICU ||
          covid_progression.getActiveSimpleState() == Clinical_Covid ||
          covid_progression.getActiveSimpleState() == Ventilator ||
          covid_progression.getActiveSimpleState() == Asymptomatic_Covid ||
          covid_progression.getActiveSimpleState() == Mild_Covid
        ) &&
        (
          flu_progression.getActiveSimpleState() == Clinical_Flu ||
          flu_progression.getActiveSimpleState() == Exposed_Flu ||
          flu_progression.getActiveSimpleState() == Asymptomatic_Flu ||
          flu_progression.getActiveSimpleState() == ICUFlu ||
          flu_progression.getActiveSimpleState() == Mild_Flu
        )
      ) {
        factor = uniform(2, 2.5);
      }
      if (
        covid_progression.getActiveSimpleState() != Clinical_Covid &&
        covid_progression.getActiveSimpleState() != ICU &&
        covid_progression.getActiveSimpleState() != Ventilator &&
        flu_progression.getActiveSimpleState() != Clinical_Flu &&
        flu_progression.getActiveSimpleState() != ICUFlu &&
        flu_progression.getActiveSimpleState() != Mild_Flu &&
        flu_progression.getActiveSimpleState() != Mild_Covid &&
        main.quarantine == false &&
        agentAge > 3
      ) {
        //start moving
        if (
          this.getEngine().getDayOfWeek() == SATURDAY ||
          this.getEngine().getDayOfWeek() == SUNDAY ||
          agentAge >= 65
        ) {
          jumpTo(agentMarket.getX(), agentMarket.getY());
        } else {
          if (agentSchool != null) {
            jumpTo(agentSchool.getX(), agentSchool.getY());
          } else {
            jumpTo(agentWorkplace.getX(), agentWorkplace.getY());
          }
        }
        location.receiveMessage("started");
      } else if (hospitalizedCovid == true || hospitalizedFlu == true) {
        moveTo(nearestHospital.getX(), nearestHospital.getY());
        location.receiveMessage("hospital");
      }
      return;
    }
    if (_e == endOfWorkDay) {
      EventTimeout self = _e;

      if (inState(AtWork)) {
        jumpTo(agentHome.getX(), agentHome.getY());
        location.receiveMessage("arrived");
      } else if (inState(AtSchool)) {
        jumpTo(agentHome.getX(), agentHome.getY());
        location.receiveMessage("arrived");
      } else if (inState(AtShoppingCentre)) {
        jumpTo(agentHome.getX(), agentHome.getY());
        location.receiveMessage("arrived");
      }
      return;
    }
    if (_e == meetingOver) {
      EventTimeout self = _e;

      if (
        (
          covid_progression.getActiveSimpleState() == ICU ||
          covid_progression.getActiveSimpleState() == Clinical_Covid ||
          covid_progression.getActiveSimpleState() == Ventilator ||
          covid_progression.getActiveSimpleState() == Asymptomatic_Covid ||
          covid_progression.getActiveSimpleState() == Mild_Covid
        ) &&
        (
          flu_progression.getActiveSimpleState() == Clinical_Flu ||
          flu_progression.getActiveSimpleState() == Exposed_Flu ||
          flu_progression.getActiveSimpleState() == Asymptomatic_Flu ||
          flu_progression.getActiveSimpleState() == ICUFlu ||
          flu_progression.getActiveSimpleState() == Mild_Flu
        )
      ) {
        factor = uniform(2, 2.5);
      }
      if (
        covid_progression.getActiveSimpleState() != Clinical_Covid &&
        covid_progression.getActiveSimpleState() != ICU &&
        covid_progression.getActiveSimpleState() != Ventilator &&
        flu_progression.getActiveSimpleState() != Clinical_Flu &&
        flu_progression.getActiveSimpleState() != ICUFlu &&
        agentAge > 3
      ) {
        if (agentAge >= 65) {
          jumpTo(agentHome.getX(), agentHome.getY());
          location.receiveMessage("endMeetingOld");
        } else {
          if (agentSchool != null) {
            jumpTo(agentSchool.getX(), agentSchool.getY());
            location.receiveMessage("endMeetingSchool");
          } else {
            jumpTo(agentWorkplace.getX(), agentWorkplace.getY());
            location.receiveMessage("endMeetingWork");
          }
        }
      } else if (hospitalizedCovid == true || hospitalizedFlu == true) {
        moveTo(nearestHospital.getX(), nearestHospital.getY());
        location.receiveMessage("hospital");
      }
      return;
    }
    if (_e == meeting) {
      EventTimeout self = _e;

      if (hasMeeting && canMeet) {
        if (inState(AtWork)) {
          jumpTo(agentMarket.getX(), agentMarket.getY());
          location.receiveMessage("meeting");
        } else if (inState(AtSchool)) {
          jumpTo(agentMarket.getX(), agentMarket.getY());
          location.receiveMessage("meeting");
        } else if (inState(AtShoppingCentre)) {
          jumpTo(agentMarket.getX(), agentMarket.getY());
          location.receiveMessage("meeting");
        } else if (inState(AtHome)) {
          jumpTo(agentMarket.getX(), agentMarket.getY());
          location.receiveMessage("meeting");
        }
      }
      return;
    }
    super.executeActionOf(_e);
  }

  // Statecharts
  public Statechart flu_progression = new Statechart(this, (short) 2);
  public Statechart covid_progression = new Statechart(this, (short) 2);
  public Statechart location = new Statechart(this, (short) 4);

  @Override
  @AnyLogicInternalCodegenAPI
  public String getNameOf(Statechart _s) {
    if (_s == this.flu_progression) return "flu_progression";
    if (_s == this.covid_progression) return "covid_progression";
    if (_s == this.location) return "location";
    return super.getNameOf(_s);
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void executeActionOf(Statechart _s) {
    if (_s == this.flu_progression) {
      enterState(Susceptible_Flu, true);
      return;
    }
    if (_s == this.covid_progression) {
      this.covidICURate = calculateCovidICURate(this.agentAge);
      this.covidClinicalRate = calculateCovidClinicalRate(this.agentAge);
      enterState(Susceptible_Covid, true);
      return;
    }
    if (_s == this.location) {
      switch (this.socialActivityStyle) {
        case MoreThanOnceWeekly:
          this.numMeetings = (int) (uniform(2, 4));
          this.numFriends = (int) (uniform(5, 7));
          break;
        case OnceWeekly:
          this.numMeetings = 1;
          this.numFriends = (int) (uniform(3, 5));
          break;
        case OnceMonthly:
          this.numMeetings = 1;
          this.numFriends = (int) (uniform(1, 3));
          break;
      }
      for (int i = 0; i < this.numFriends; i++) {
        this.friendContacts.add(main.people.random());
      }
      enterState(AtHome, true);
      return;
    }
    super.executeActionOf(_s);
  }

  // States of all statecharts

  @AnyLogicCustomProposalPriority(
    type = AnyLogicCustomProposalPriority.Type.STATIC_ELEMENT
  )
  public static final short Susceptible_Flu = 0;

  @AnyLogicCustomProposalPriority(
    type = AnyLogicCustomProposalPriority.Type.STATIC_ELEMENT
  )
  public static final short Exposed_Flu = 1;

  @AnyLogicCustomProposalPriority(
    type = AnyLogicCustomProposalPriority.Type.STATIC_ELEMENT
  )
  public static final short Infectious_Flu = 2;

  @AnyLogicCustomProposalPriority(
    type = AnyLogicCustomProposalPriority.Type.STATIC_ELEMENT
  )
  public static final short Clinical_Flu = 3;

  @AnyLogicCustomProposalPriority(
    type = AnyLogicCustomProposalPriority.Type.STATIC_ELEMENT
  )
  public static final short ICUFlu = 4;

  @AnyLogicCustomProposalPriority(
    type = AnyLogicCustomProposalPriority.Type.STATIC_ELEMENT
  )
  public static final short Recovered_Flu = 5;

  @AnyLogicCustomProposalPriority(
    type = AnyLogicCustomProposalPriority.Type.STATIC_ELEMENT
  )
  public static final short Asymptomatic_Flu = 6;

  @AnyLogicCustomProposalPriority(
    type = AnyLogicCustomProposalPriority.Type.STATIC_ELEMENT
  )
  public static final short Mild_Flu = 7;

  @AnyLogicCustomProposalPriority(
    type = AnyLogicCustomProposalPriority.Type.STATIC_ELEMENT
  )
  public static final short branch12 = 8;

  @AnyLogicCustomProposalPriority(
    type = AnyLogicCustomProposalPriority.Type.STATIC_ELEMENT
  )
  public static final short branch = 9;

  @AnyLogicCustomProposalPriority(
    type = AnyLogicCustomProposalPriority.Type.STATIC_ELEMENT
  )
  public static final short branch5 = 10;

  @AnyLogicCustomProposalPriority(
    type = AnyLogicCustomProposalPriority.Type.STATIC_ELEMENT
  )
  public static final short branch1 = 11;

  @AnyLogicCustomProposalPriority(
    type = AnyLogicCustomProposalPriority.Type.STATIC_ELEMENT
  )
  public static final short finalState_Flu = 12;

  @AnyLogicCustomProposalPriority(
    type = AnyLogicCustomProposalPriority.Type.STATIC_ELEMENT
  )
  public static final short Susceptible_Covid = 13;

  @AnyLogicCustomProposalPriority(
    type = AnyLogicCustomProposalPriority.Type.STATIC_ELEMENT
  )
  public static final short Exposed_Covid = 14;

  @AnyLogicCustomProposalPriority(
    type = AnyLogicCustomProposalPriority.Type.STATIC_ELEMENT
  )
  public static final short Infectious_Covid = 15;

  @AnyLogicCustomProposalPriority(
    type = AnyLogicCustomProposalPriority.Type.STATIC_ELEMENT
  )
  public static final short Asymptomatic_Covid = 16;

  @AnyLogicCustomProposalPriority(
    type = AnyLogicCustomProposalPriority.Type.STATIC_ELEMENT
  )
  public static final short Recovered_Covid = 17;

  @AnyLogicCustomProposalPriority(
    type = AnyLogicCustomProposalPriority.Type.STATIC_ELEMENT
  )
  public static final short Mild_Covid = 18;

  @AnyLogicCustomProposalPriority(
    type = AnyLogicCustomProposalPriority.Type.STATIC_ELEMENT
  )
  public static final short Clinical_Covid = 19;

  @AnyLogicCustomProposalPriority(
    type = AnyLogicCustomProposalPriority.Type.STATIC_ELEMENT
  )
  public static final short ICU = 20;

  @AnyLogicCustomProposalPriority(
    type = AnyLogicCustomProposalPriority.Type.STATIC_ELEMENT
  )
  public static final short Ventilator = 21;

  @AnyLogicCustomProposalPriority(
    type = AnyLogicCustomProposalPriority.Type.STATIC_ELEMENT
  )
  public static final short branch7 = 22;

  @AnyLogicCustomProposalPriority(
    type = AnyLogicCustomProposalPriority.Type.STATIC_ELEMENT
  )
  public static final short branch2 = 23;

  @AnyLogicCustomProposalPriority(
    type = AnyLogicCustomProposalPriority.Type.STATIC_ELEMENT
  )
  public static final short branch8 = 24;

  @AnyLogicCustomProposalPriority(
    type = AnyLogicCustomProposalPriority.Type.STATIC_ELEMENT
  )
  public static final short branch9 = 25;

  @AnyLogicCustomProposalPriority(
    type = AnyLogicCustomProposalPriority.Type.STATIC_ELEMENT
  )
  public static final short branch6 = 26;

  @AnyLogicCustomProposalPriority(
    type = AnyLogicCustomProposalPriority.Type.STATIC_ELEMENT
  )
  public static final short finalState_Covid = 27;

  @AnyLogicCustomProposalPriority(
    type = AnyLogicCustomProposalPriority.Type.STATIC_ELEMENT
  )
  public static final short AtHome = 28;

  @AnyLogicCustomProposalPriority(
    type = AnyLogicCustomProposalPriority.Type.STATIC_ELEMENT
  )
  public static final short AtWork = 29;

  @AnyLogicCustomProposalPriority(
    type = AnyLogicCustomProposalPriority.Type.STATIC_ELEMENT
  )
  public static final short AtShoppingCentre = 30;

  @AnyLogicCustomProposalPriority(
    type = AnyLogicCustomProposalPriority.Type.STATIC_ELEMENT
  )
  public static final short AtSchool = 31;

  @AnyLogicCustomProposalPriority(
    type = AnyLogicCustomProposalPriority.Type.STATIC_ELEMENT
  )
  public static final short Hospital = 32;

  @AnyLogicCustomProposalPriority(
    type = AnyLogicCustomProposalPriority.Type.STATIC_ELEMENT
  )
  public static final short branch11 = 33;

  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final short _STATECHART_ELEMENT_NEXT_ID_xjal = 34;

  @Override
  public boolean inState(short _state) {
    switch (_state) {
      case Susceptible_Flu:
      case Exposed_Flu:
      case Infectious_Flu:
      case Clinical_Flu:
      case ICUFlu:
      case Recovered_Flu:
      case Asymptomatic_Flu:
      case Mild_Flu:
      case branch12:
      case branch:
      case branch5:
      case branch1:
      case finalState_Flu:
        return flu_progression.isStateActive(_state);
      case Susceptible_Covid:
      case Exposed_Covid:
      case Infectious_Covid:
      case Asymptomatic_Covid:
      case Recovered_Covid:
      case Mild_Covid:
      case Clinical_Covid:
      case ICU:
      case Ventilator:
      case branch7:
      case branch2:
      case branch8:
      case branch9:
      case branch6:
      case finalState_Covid:
        return covid_progression.isStateActive(_state);
      case AtHome:
      case AtWork:
      case AtShoppingCentre:
      case AtSchool:
      case Hospital:
      case branch11:
        return location.isStateActive(_state);
      default:
        return super.inState(_state);
    }
  }

  @Override
  public String getNameOfState(short _state) {
    switch (_state) {
      case Susceptible_Flu:
        return "Susceptible_Flu";
      case Exposed_Flu:
        return "Exposed_Flu";
      case Infectious_Flu:
        return "Infectious_Flu";
      case Clinical_Flu:
        return "Clinical_Flu";
      case ICUFlu:
        return "ICUFlu";
      case Recovered_Flu:
        return "Recovered_Flu";
      case Asymptomatic_Flu:
        return "Asymptomatic_Flu";
      case Mild_Flu:
        return "Mild_Flu";
      case branch12:
        return "branch12";
      case branch:
        return "branch";
      case branch5:
        return "branch5";
      case branch1:
        return "branch1";
      case finalState_Flu:
        return "finalState_Flu";
      case Susceptible_Covid:
        return "Susceptible_Covid";
      case Exposed_Covid:
        return "Exposed_Covid";
      case Infectious_Covid:
        return "Infectious_Covid";
      case Asymptomatic_Covid:
        return "Asymptomatic_Covid";
      case Recovered_Covid:
        return "Recovered_Covid";
      case Mild_Covid:
        return "Mild_Covid";
      case Clinical_Covid:
        return "Clinical_Covid";
      case ICU:
        return "ICU";
      case Ventilator:
        return "Ventilator";
      case branch7:
        return "branch7";
      case branch2:
        return "branch2";
      case branch8:
        return "branch8";
      case branch9:
        return "branch9";
      case branch6:
        return "branch6";
      case finalState_Covid:
        return "finalState_Covid";
      case AtHome:
        return "AtHome";
      case AtWork:
        return "AtWork";
      case AtShoppingCentre:
        return "AtShoppingCentre";
      case AtSchool:
        return "AtSchool";
      case Hospital:
        return "Hospital";
      case branch11:
        return "branch11";
      default:
        return super.getNameOfState(_state);
    }
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void enterState(short _state, boolean _destination) {
    switch (_state) {
      case Susceptible_Flu: // (Simple state (not composite))
        flu_progression.setActiveState_xjal(Susceptible_Flu);
        {
          main.nSusceptibleFlu++;
          canMeet = true;
        }
        transition16.start();
        return;
      case Exposed_Flu: // (Simple state (not composite))
        flu_progression.setActiveState_xjal(Exposed_Flu);
        {
          main.nExposedFlu++;
          canMeet = true;
        }
        transition18.start();
        return;
      case Infectious_Flu: // (Simple state (not composite))
        flu_progression.setActiveState_xjal(Infectious_Flu);
        {
          main.nInfectiousFlu++;
          canMeet = true;
        }
        transition48.start();
        transition19.start();
        return;
      case Clinical_Flu: // (Simple state (not composite))
        flu_progression.setActiveState_xjal(Clinical_Flu);
        {
          main.nClinicalFlu++;
          hospitalizedFlu = true;
          canMeet = false;
          main.nHospitalized++;
        }
        transition.start();
        transition49.start();
        return;
      case ICUFlu: // (Simple state (not composite))
        flu_progression.setActiveState_xjal(ICUFlu);
        {
          main.nICUFlu++;
          hospitalizedFlu = true;
          canMeet = false;
          main.nHospitalized++;
        }
        transition3.start();
        transition53.start();
        return;
      case Recovered_Flu: // (Simple state (not composite))
        flu_progression.setActiveState_xjal(Recovered_Flu);
        {
          main.nRecoveredFlu++;
          hospitalizedFlu = false;
          canMeet = true;
        }
        return;
      case Asymptomatic_Flu: // (Simple state (not composite))
        flu_progression.setActiveState_xjal(Asymptomatic_Flu);
        {
          main.nAsymptomaticFlu++;
          canMeet = true;
        }
        transition57.start();
        transition35.start();
        return;
      case Mild_Flu: // (Simple state (not composite))
        flu_progression.setActiveState_xjal(Mild_Flu);
        {
          main.nMildFlu++;
          canMeet = false;
        }
        transition59.start();
        transition43.start();
        return;
      case branch12: // (Branch)
        if (randomTrue(fluClinicalRate)) { // transition22
          enterState(Clinical_Flu, true);
          return;
        }
        // transition47 (default)
        enterState(branch1, true);
        return;
      case branch: // (Branch)
        if (randomTrue(fluICURate)) { // transition1
          enterState(ICUFlu, true);
          return;
        }
        // transition2 (default)
        enterState(Recovered_Flu, true);
        return;
      case branch5: // (Branch)
        if (randomTrue(calculateFluMortalityRate(agentAge) * fluDangerFactor)) { // transition23
          enterState(finalState_Flu, true);
          return;
        }
        // transition21 (default)
        enterState(Recovered_Flu, true);
        return;
      case branch1: // (Branch)
        if (randomTrue(uniform(0.17, 0.77))) { // transition10
          enterState(Asymptomatic_Flu, true);
          return;
        }
        // transition11 (default)
        enterState(Mild_Flu, true);
        return;
      case finalState_Flu: // (Final State)
        {
          main.nDeceasedFlu++;
        }
        flu_progression.setActiveState_xjal(finalState_Flu);
        flu_progression.onDestroy();
        return;
      case Susceptible_Covid: // (Simple state (not composite))
        covid_progression.setActiveState_xjal(Susceptible_Covid);
        {
          main.nSusceptibleCovid++;
          canMeet = true;
        }
        transition24.start();
        return;
      case Exposed_Covid: // (Simple state (not composite))
        covid_progression.setActiveState_xjal(Exposed_Covid);
        {
          main.nExposedCovid++;
          canMeet = true;
        }
        transition26.start();
        return;
      case Infectious_Covid: // (Simple state (not composite))
        covid_progression.setActiveState_xjal(Infectious_Covid);
        {
          main.nInfectiousCovid++;
          canMeet = true;
        }
        transition25.start();
        transition58.start();
        return;
      case Asymptomatic_Covid: // (Simple state (not composite))
        covid_progression.setActiveState_xjal(Asymptomatic_Covid);
        {
          main.nAsymptomaticCovid++;
          hospitalizedCovid = false;
          canMeet = true;
        }
        transition27.start();
        transition34.start();
        return;
      case Recovered_Covid: // (Simple state (not composite))
        covid_progression.setActiveState_xjal(Recovered_Covid);
        {
          main.nRecoveredCovid++;
          canMeet = true;
        }
        transition30.start();
        return;
      case Mild_Covid: // (Simple state (not composite))
        covid_progression.setActiveState_xjal(Mild_Covid);
        {
          main.nMildCovid++;
          canMeet = false;
        }
        transition60.start();
        transition61.start();
        return;
      case Clinical_Covid: // (Simple state (not composite))
        covid_progression.setActiveState_xjal(Clinical_Covid);
        {
          main.nClinicalCovid++;
          hospitalizedCovid = true;
          canMeet = false;
          main.nHospitalized++;
        }
        transition36.start();
        transition40.start();
        return;
      case ICU: // (Simple state (not composite))
        covid_progression.setActiveState_xjal(ICU);
        {
          main.nICUCovid++;
          hospitalizedCovid = true;
          canMeet = false;
          main.nHospitalized++;
        }
        transition39.start();
        return;
      case Ventilator: // (Simple state (not composite))
        covid_progression.setActiveState_xjal(Ventilator);
        {
          main.nVentilatorCovid++;
          hospitalizedCovid = true;
          canMeet = false;
          main.nHospitalized++;
        }
        transition29.start();
        return;
      case branch7: // (Branch)
        if (randomTrue(covidClinicalRate)) { // transition33
          enterState(Clinical_Covid, true);
          return;
        }
        // transition32 (default)
        enterState(branch2, true);
        return;
      case branch2: // (Branch)
        if (randomTrue(uniform(0.18, 0.81))) { // transition12
          enterState(Asymptomatic_Covid, true);
          return;
        }
        // transition13 (default)
        enterState(Mild_Covid, true);
        return;
      case branch8: // (Branch)
        if (randomTrue(covidICURate)) { // transition37
          enterState(ICU, true);
          return;
        }
        // transition28 (default)
        enterState(Asymptomatic_Covid, true);
        return;
      case branch9: // (Branch)
        if (randomTrue(uniform(0.70, 0.88))) { // transition38
          enterState(Ventilator, true);
          return;
        }
        // transition41 (default)
        enterState(Asymptomatic_Covid, true);
        return;
      case branch6: // (Branch)
        if (
          randomTrue(calculateCovidMortalityRate(agentAge) * covidDangerFactor)
        ) { // transition31
          enterState(finalState_Covid, true);
          return;
        }
        // transition42 (default)
        enterState(Asymptomatic_Covid, true);
        return;
      case finalState_Covid: // (Final State)
        {
          main.nDeceasedCovid++;
        }
        covid_progression.setActiveState_xjal(finalState_Covid);
        covid_progression.onDestroy();
        return;
      case AtHome: // (Simple state (not composite))
        location.setActiveState_xjal(AtHome);
        {
          maskFactor = 0;
        }
        transition54.start();
        transition46.start();
        transition6.start();
        return;
      case AtWork: // (Simple state (not composite))
        location.setActiveState_xjal(AtWork);
        {
          agentWorkplace.colleagues.add(this);
        }
        transition45.start();
        transition5.start();
        return;
      case AtShoppingCentre: // (Simple state (not composite))
        location.setActiveState_xjal(AtShoppingCentre);
        {
          agentMarket.shoppers.add(this);
        }
        transition55.start();
        transition7.start();
        transition8.start();
        transition9.start();
        return;
      case AtSchool: // (Simple state (not composite))
        location.setActiveState_xjal(AtSchool);
        {
          agentSchool.classmates.add(this);
        }
        transition50.start();
        transition4.start();
        return;
      case Hospital: // (Simple state (not composite))
        location.setActiveState_xjal(Hospital);
        {
          this.nearestHospital.patients.add(this);
        }
        transition56.start();
        return;
      case branch11: // (Branch)
        if (
          this.agentWorkplace != null &&
          (
            this.getEngine().getDayOfWeek() != SATURDAY ||
            this.getEngine().getDayOfWeek() != SUNDAY
          )
        ) { // transition44
          enterState(AtWork, true);
          return;
        }
        if (
          this.agentSchool != null &&
          (
            this.getEngine().getDayOfWeek() != SATURDAY &&
            this.getEngine().getDayOfWeek() != SUNDAY
          )
        ) { // transition51
          enterState(AtSchool, true);
          return;
        }
        // transition52 (default)
        enterState(AtShoppingCentre, true);
        return;
      default:
        super.enterState(_state, _destination);
        return;
    }
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void exitState(
    short _state,
    Transition _t,
    boolean _source,
    Statechart _statechart
  ) {
    switch (_state) {
      case Susceptible_Flu: // (Simple state (not composite))
        if (!_source || _t != transition16) transition16.cancel();
        {
          main.nSusceptibleFlu--;
        }
        return;
      case Exposed_Flu: // (Simple state (not composite))
        if (!_source || _t != transition18) transition18.cancel();
        {
          main.nExposedFlu--;
        }
        return;
      case Infectious_Flu: // (Simple state (not composite))
        if (!_source || _t != transition48) transition48.cancel();
        if (!_source || _t != transition19) transition19.cancel();
        {
          main.nInfectiousFlu--;
        }
        return;
      case Clinical_Flu: // (Simple state (not composite))
        if (!_source || _t != transition) transition.cancel();
        if (!_source || _t != transition49) transition49.cancel();
        {
          main.nClinicalFlu--;
          main.nHospitalized--;
        }
        return;
      case ICUFlu: // (Simple state (not composite))
        if (!_source || _t != transition3) transition3.cancel();
        if (!_source || _t != transition53) transition53.cancel();
        {
          main.nICUFlu--;
          main.nHospitalized--;
        }
        return;
      case Recovered_Flu: // (Simple state (not composite))
        {
          main.nRecoveredFlu--;
        }
        return;
      case Asymptomatic_Flu: // (Simple state (not composite))
        if (!_source || _t != transition57) transition57.cancel();
        if (!_source || _t != transition35) transition35.cancel();
        {
          main.nAsymptomaticFlu--;
        }
        return;
      case Mild_Flu: // (Simple state (not composite))
        if (!_source || _t != transition59) transition59.cancel();
        if (!_source || _t != transition43) transition43.cancel();
        {
          main.nMildFlu--;
        }
        return;
      case Susceptible_Covid: // (Simple state (not composite))
        if (!_source || _t != transition24) transition24.cancel();
        {
          main.nSusceptibleCovid--;
        }
        return;
      case Exposed_Covid: // (Simple state (not composite))
        if (!_source || _t != transition26) transition26.cancel();
        {
          main.nExposedCovid--;
        }
        return;
      case Infectious_Covid: // (Simple state (not composite))
        if (!_source || _t != transition25) transition25.cancel();
        if (!_source || _t != transition58) transition58.cancel();
        {
          main.nInfectiousCovid--;
        }
        return;
      case Asymptomatic_Covid: // (Simple state (not composite))
        if (!_source || _t != transition27) transition27.cancel();
        if (!_source || _t != transition34) transition34.cancel();
        {
          main.nAsymptomaticCovid--;
        }
        return;
      case Recovered_Covid: // (Simple state (not composite))
        if (!_source || _t != transition30) transition30.cancel();
        {
          main.nRecoveredCovid--;
        }
        return;
      case Mild_Covid: // (Simple state (not composite))
        if (!_source || _t != transition60) transition60.cancel();
        if (!_source || _t != transition61) transition61.cancel();
        {
          main.nMildCovid--;
        }
        return;
      case Clinical_Covid: // (Simple state (not composite))
        if (!_source || _t != transition36) transition36.cancel();
        if (!_source || _t != transition40) transition40.cancel();
        {
          main.nClinicalCovid--;
          main.nHospitalized--;
        }
        return;
      case ICU: // (Simple state (not composite))
        if (!_source || _t != transition39) transition39.cancel();
        {
          main.nICUCovid--;
          main.nHospitalized--;
        }
        return;
      case Ventilator: // (Simple state (not composite))
        if (!_source || _t != transition29) transition29.cancel();
        {
          main.nVentilatorCovid--;
          main.nHospitalized--;
        }
        return;
      case AtHome: // (Simple state (not composite))
        if (!_source || _t != transition54) transition54.cancel();
        if (!_source || _t != transition46) transition46.cancel();
        if (!_source || _t != transition6) transition6.cancel();
        {
          maskFactor = main.masks;
        }
        return;
      case AtWork: // (Simple state (not composite))
        if (!_source || _t != transition45) transition45.cancel();
        if (!_source || _t != transition5) transition5.cancel();
        {
          agentWorkplace.colleagues.remove(this);
        }
        return;
      case AtShoppingCentre: // (Simple state (not composite))
        if (!_source || _t != transition55) transition55.cancel();
        if (!_source || _t != transition7) transition7.cancel();
        if (!_source || _t != transition8) transition8.cancel();
        if (!_source || _t != transition9) transition9.cancel();
        {
          agentMarket.shoppers.remove(this);
        }
        return;
      case AtSchool: // (Simple state (not composite))
        if (!_source || _t != transition50) transition50.cancel();
        if (!_source || _t != transition4) transition4.cancel();
        {
          agentSchool.classmates.remove(this);
        }
        return;
      case Hospital: // (Simple state (not composite))
        if (!_source || _t != transition56) transition56.cancel();
        {
          this.nearestHospital.patients.remove(this);
        }
        return;
      default:
        super.exitState(_state, _t, _source, _statechart);
        return;
    }
  }

  public TransitionTimeout transition18 = new TransitionTimeout(this);
  public TransitionTimeout transition19 = new TransitionTimeout(this);
  public TransitionTimeout transition = new TransitionTimeout(this);
  public TransitionTimeout transition3 = new TransitionTimeout(this);
  public TransitionTimeout transition57 = new TransitionTimeout(this);
  public TransitionTimeout transition59 = new TransitionTimeout(this);
  public TransitionTimeout transition26 = new TransitionTimeout(this);
  public TransitionTimeout transition58 = new TransitionTimeout(this);
  public TransitionTimeout transition34 = new TransitionTimeout(this);
  public TransitionTimeout transition30 = new TransitionTimeout(this);
  public TransitionTimeout transition60 = new TransitionTimeout(this);
  public TransitionTimeout transition36 = new TransitionTimeout(this);
  public TransitionTimeout transition39 = new TransitionTimeout(this);
  public TransitionTimeout transition29 = new TransitionTimeout(this);

  @Override
  @AnyLogicInternalCodegenAPI
  public String getNameOf(TransitionTimeout _t) {
    if (_t == transition18) return "transition18";
    if (_t == transition19) return "transition19";
    if (_t == transition) return "transition";
    if (_t == transition3) return "transition3";
    if (_t == transition57) return "transition57";
    if (_t == transition59) return "transition59";
    if (_t == transition26) return "transition26";
    if (_t == transition58) return "transition58";
    if (_t == transition34) return "transition34";
    if (_t == transition30) return "transition30";
    if (_t == transition60) return "transition60";
    if (_t == transition36) return "transition36";
    if (_t == transition39) return "transition39";
    if (_t == transition29) return "transition29";
    return super.getNameOf(_t);
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public Statechart getStatechartOf(TransitionTimeout _t) {
    if (_t == transition18) return flu_progression;
    if (_t == transition19) return flu_progression;
    if (_t == transition) return flu_progression;
    if (_t == transition3) return flu_progression;
    if (_t == transition57) return flu_progression;
    if (_t == transition59) return flu_progression;
    if (_t == transition26) return covid_progression;
    if (_t == transition58) return covid_progression;
    if (_t == transition34) return covid_progression;
    if (_t == transition30) return covid_progression;
    if (_t == transition60) return covid_progression;
    if (_t == transition36) return covid_progression;
    if (_t == transition39) return covid_progression;
    if (_t == transition29) return covid_progression;
    return super.getStatechartOf(_t);
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void executeActionOf(TransitionTimeout _t) {
    if (_t == transition18) {
      exitState(Exposed_Flu, _t, true, flu_progression);
      enterState(Infectious_Flu, true);
      return;
    }
    if (_t == transition19) {
      exitState(Infectious_Flu, _t, true, flu_progression);
      enterState(branch12, true);
      return;
    }
    if (_t == transition) {
      exitState(Clinical_Flu, _t, true, flu_progression);
      enterState(branch, true);
      return;
    }
    if (_t == transition3) {
      exitState(ICUFlu, _t, true, flu_progression);
      enterState(branch5, true);
      return;
    }
    if (_t == transition57) {
      exitState(Asymptomatic_Flu, _t, true, flu_progression);
      enterState(Recovered_Flu, true);
      return;
    }
    if (_t == transition59) {
      exitState(Mild_Flu, _t, true, flu_progression);
      enterState(Recovered_Flu, true);
      return;
    }
    if (_t == transition26) {
      exitState(Exposed_Covid, _t, true, covid_progression);
      enterState(Infectious_Covid, true);
      return;
    }
    if (_t == transition58) {
      exitState(Infectious_Covid, _t, true, covid_progression);
      enterState(branch7, true);
      return;
    }
    if (_t == transition34) {
      exitState(Asymptomatic_Covid, _t, true, covid_progression);
      enterState(Recovered_Covid, true);
      return;
    }
    if (_t == transition30) {
      exitState(Recovered_Covid, _t, true, covid_progression);
      enterState(Susceptible_Covid, true);
      return;
    }
    if (_t == transition60) {
      exitState(Mild_Covid, _t, true, covid_progression);
      enterState(Recovered_Covid, true);
      return;
    }
    if (_t == transition36) {
      exitState(Clinical_Covid, _t, true, covid_progression);
      enterState(branch8, true);
      return;
    }
    if (_t == transition39) {
      exitState(ICU, _t, true, covid_progression);
      enterState(branch9, true);
      return;
    }
    if (_t == transition29) {
      exitState(Ventilator, _t, true, covid_progression);
      enterState(branch6, true);
      return;
    }
    super.executeActionOf(_t);
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public double evaluateTimeoutOf(TransitionTimeout _t) {
    if (_t == transition18) return triangular(1, 1.5, 3);
    if (_t == transition19) return triangular(1, 1.5, 3);
    if (_t == transition) return triangular(4, 8, 7) * factor;
    if (_t == transition3) return triangular(8, 15, 14) * factor;
    if (_t == transition57) return triangular(2, 3.5, 5);
    if (_t == transition59) return triangular(2, 3.5, 5);
    if (_t == transition26) return //timtoTimeout(DAY, uniform(1,4))
    toTimeout(DAY, (int) uniform(3, 5));
    if (_t == transition58) return //timtoTimeout(DAY, uniform(1,4))
    toTimeout(DAY, (int) uniform(3, 5));
    if (_t == transition34) return toTimeout(DAY, (int) uniform(12, 14));
    if (_t == transition30) return toTimeout(MONTH, (int) uniform(1, 2));
    if (_t == transition60) return toTimeout(DAY, (int) uniform(12, 14));
    if (_t == transition36) return triangular(7, 14) * factor;
    if (_t == transition39) return triangular(7, 8, 9) * factor;
    if (_t == transition29) return triangular(5, 7, 12) * factor;
    return super.evaluateTimeoutOf(_t);
  }

  public TransitionRate transition48 = new TransitionRate(this);
  public TransitionRate transition53 = new TransitionRate(this);
  public TransitionRate transition49 = new TransitionRate(this);
  public TransitionRate transition35 = new TransitionRate(this);
  public TransitionRate transition43 = new TransitionRate(this);
  public TransitionRate transition25 = new TransitionRate(this);
  public TransitionRate transition27 = new TransitionRate(this);
  public TransitionRate transition61 = new TransitionRate(this);
  public TransitionRate transition40 = new TransitionRate(this);

  @Override
  @AnyLogicInternalCodegenAPI
  public String getNameOf(TransitionRate _t) {
    if (_t == transition48) return "transition48";
    if (_t == transition53) return "transition53";
    if (_t == transition49) return "transition49";
    if (_t == transition35) return "transition35";
    if (_t == transition43) return "transition43";
    if (_t == transition25) return "transition25";
    if (_t == transition27) return "transition27";
    if (_t == transition61) return "transition61";
    if (_t == transition40) return "transition40";
    return super.getNameOf(_t);
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public Statechart getStatechartOf(TransitionRate _t) {
    if (_t == transition48) return flu_progression;
    if (_t == transition53) return flu_progression;
    if (_t == transition49) return flu_progression;
    if (_t == transition35) return flu_progression;
    if (_t == transition43) return flu_progression;
    if (_t == transition25) return covid_progression;
    if (_t == transition27) return covid_progression;
    if (_t == transition61) return covid_progression;
    if (_t == transition40) return covid_progression;
    return super.getStatechartOf(_t);
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void executeActionOf(TransitionRate _t) {
    if (_t == transition48) {
      {
        sendToInfectionGroup("flu");
      }
      transition48.start();
      return;
    }
    if (_t == transition53) {
      {
        sendToInfectionGroup("flu");
      }
      transition53.start();
      return;
    }
    if (_t == transition49) {
      {
        sendToInfectionGroup("flu");
      }
      transition49.start();
      return;
    }
    if (_t == transition35) {
      {
        sendToInfectionGroup("flu");
      }
      transition35.start();
      return;
    }
    if (_t == transition43) {
      {
        sendToInfectionGroup("flu");
      }
      transition43.start();
      return;
    }
    if (_t == transition25) {
      {
        sendToInfectionGroup("covid");
      }
      transition25.start();
      return;
    }
    if (_t == transition27) {
      {
        sendToInfectionGroup("covid");
      }
      transition27.start();
      return;
    }
    if (_t == transition61) {
      {
        sendToInfectionGroup("covid");
      }
      transition61.start();
      return;
    }
    if (_t == transition40) {
      {
        sendToInfectionGroup("covid");
      }
      transition40.start();
      return;
    }
    super.executeActionOf(_t);
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public double evaluateRateOf(TransitionRate _t) {
    if (_t == transition48) return (
      uniform(0.4, 0.5) * ((100 - maskFactor) / 100)
    );
    if (_t == transition53) return (
      uniform(0.4, 0.5) * ((100 - maskFactor) / 100)
    );
    if (_t == transition49) return (
      uniform(0.4, 0.5) * ((100 - maskFactor) / 100)
    );
    if (_t == transition35) return (
      uniform(0.4, 0.5) * ((100 - maskFactor) / 100)
    );
    if (_t == transition43) return (
      uniform(0.4, 0.5) * ((100 - maskFactor) / 100)
    );
    if (_t == transition25) return (
      uniform(0.5, 1.5) * ((100 - maskFactor) / 100)
    );
    if (_t == transition27) return (
      uniform(0.5, 1.5) * ((100 - maskFactor) / 100)
    );
    if (_t == transition61) return (
      uniform(0.5, 1.5) * ((100 - maskFactor) / 100)
    );
    if (_t == transition40) return (
      uniform(0.5, 1.5) * ((100 - maskFactor) / 100)
    );
    return super.evaluateRateOf(_t);
  }

  public TransitionMessage transition16 = new TransitionMessage(this);
  public TransitionMessage transition24 = new TransitionMessage(this);
  public TransitionMessage transition54 = new TransitionMessage(this);
  public TransitionMessage transition45 = new TransitionMessage(this);
  public TransitionMessage transition5 = new TransitionMessage(this);
  public TransitionMessage transition55 = new TransitionMessage(this);
  public TransitionMessage transition7 = new TransitionMessage(this);
  public TransitionMessage transition50 = new TransitionMessage(this);
  public TransitionMessage transition4 = new TransitionMessage(this);
  public TransitionMessage transition8 = new TransitionMessage(this);
  public TransitionMessage transition9 = new TransitionMessage(this);
  public TransitionMessage transition46 = new TransitionMessage(this);
  public TransitionMessage transition56 = new TransitionMessage(this);
  public TransitionMessage transition6 = new TransitionMessage(this);

  @Override
  @AnyLogicInternalCodegenAPI
  public String getNameOf(TransitionMessage _t) {
    if (_t == transition16) return "transition16";
    if (_t == transition24) return "transition24";
    if (_t == transition54) return "transition54";
    if (_t == transition45) return "transition45";
    if (_t == transition5) return "transition5";
    if (_t == transition55) return "transition55";
    if (_t == transition7) return "transition7";
    if (_t == transition50) return "transition50";
    if (_t == transition4) return "transition4";
    if (_t == transition8) return "transition8";
    if (_t == transition9) return "transition9";
    if (_t == transition46) return "transition46";
    if (_t == transition56) return "transition56";
    if (_t == transition6) return "transition6";
    return super.getNameOf(_t);
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public Statechart getStatechartOf(TransitionMessage _t) {
    if (_t == transition16) return flu_progression;
    if (_t == transition24) return covid_progression;
    if (_t == transition54) return location;
    if (_t == transition45) return location;
    if (_t == transition5) return location;
    if (_t == transition55) return location;
    if (_t == transition7) return location;
    if (_t == transition50) return location;
    if (_t == transition4) return location;
    if (_t == transition8) return location;
    if (_t == transition9) return location;
    if (_t == transition46) return location;
    if (_t == transition56) return location;
    if (_t == transition6) return location;
    return super.getStatechartOf(_t);
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void executeActionOf(TransitionMessage _t, Object _msg) {
    if (_t == transition16) {
      exitState(Susceptible_Flu, _t, true, flu_progression);
      enterState(Exposed_Flu, true);
      return;
    }
    if (_t == transition24) {
      exitState(Susceptible_Covid, _t, true, covid_progression);
      enterState(Exposed_Covid, true);
      return;
    }
    if (_t == transition54) {
      exitState(AtHome, _t, true, location);
      enterState(branch11, true);
      return;
    }
    if (_t == transition45) {
      exitState(AtWork, _t, true, location);
      enterState(AtHome, true);
      return;
    }
    if (_t == transition5) {
      exitState(AtWork, _t, true, location);
      enterState(AtShoppingCentre, true);
      return;
    }
    if (_t == transition55) {
      exitState(AtShoppingCentre, _t, true, location);
      enterState(AtHome, true);
      return;
    }
    if (_t == transition7) {
      exitState(AtShoppingCentre, _t, true, location);
      enterState(AtSchool, true);
      return;
    }
    if (_t == transition50) {
      exitState(AtSchool, _t, true, location);
      enterState(AtHome, true);
      return;
    }
    if (_t == transition4) {
      exitState(AtSchool, _t, true, location);
      enterState(AtShoppingCentre, true);
      return;
    }
    if (_t == transition8) {
      exitState(AtShoppingCentre, _t, true, location);
      enterState(AtWork, true);
      return;
    }
    if (_t == transition9) {
      exitState(AtShoppingCentre, _t, true, location);
      enterState(AtHome, true);
      return;
    }
    if (_t == transition46) {
      exitState(AtHome, _t, true, location);
      {
        Object msg = (Object) _msg;
        main.nHospitalized++;
      }
      enterState(Hospital, true);
      return;
    }
    if (_t == transition56) {
      exitState(Hospital, _t, true, location);
      {
        Object msg = (Object) _msg;
        main.nHospitalized--;
      }
      enterState(AtHome, true);
      return;
    }
    if (_t == transition6) {
      exitState(AtHome, _t, true, location);
      enterState(AtShoppingCentre, true);
      return;
    }
    super.executeActionOf(_t, _msg);
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public boolean testMessageOf(TransitionMessage _t, Object _msg) {
    if (_t == transition16) {
      if (!(_msg instanceof String)) return false;

      String msg = (String) _msg;
      Object _g = "flu";
      return msg.equals(_g);
    }
    if (_t == transition24) {
      if (!(_msg instanceof String)) return false;

      String msg = (String) _msg;
      Object _g = "covid";
      return msg.equals(_g);
    }
    if (_t == transition54) {
      Object msg = (Object) _msg;
      Object _g = "started";
      return msg.equals(_g);
    }
    if (_t == transition45) {
      Object msg = (Object) _msg;
      Object _g = "arrived";
      return msg.equals(_g);
    }
    if (_t == transition5) {
      Object msg = (Object) _msg;
      Object _g = "meeting";
      return msg.equals(_g);
    }
    if (_t == transition55) {
      Object msg = (Object) _msg;
      Object _g = "arrived";
      return msg.equals(_g);
    }
    if (_t == transition7) {
      Object msg = (Object) _msg;
      Object _g = "endMeetingSchool";
      return msg.equals(_g);
    }
    if (_t == transition50) {
      Object msg = (Object) _msg;
      Object _g = "arrived";
      return msg.equals(_g);
    }
    if (_t == transition4) {
      Object msg = (Object) _msg;
      Object _g = "meeting";
      return msg.equals(_g);
    }
    if (_t == transition8) {
      Object msg = (Object) _msg;
      Object _g = "endMeetingWork";
      return msg.equals(_g);
    }
    if (_t == transition9) {
      Object msg = (Object) _msg;
      Object _g = "endMeetingOld";
      return msg.equals(_g);
    }
    if (_t == transition46) {
      Object msg = (Object) _msg;
      Object _g = "hospital";
      return msg.equals(_g);
    }
    if (_t == transition56) {
      Object msg = (Object) _msg;
      boolean _g =
        covid_progression.getActiveSimpleState() != Clinical_Covid &&
        covid_progression.getActiveSimpleState() != ICU &&
        covid_progression.getActiveSimpleState() != Ventilator;
      return _g;
    }
    if (_t == transition6) {
      Object msg = (Object) _msg;
      Object _g = "meeting";
      return msg.equals(_g);
    }
    return super.testMessageOf(_t, _msg);
  }

  // Functions

  void create_schedule(int numMeetings) {
    List<Integer> dates = new ArrayList<Integer>();
    for (int i = 1; i <= 7; i++) {
      dates.add(i);
    }

    for (int i = 0; i < numMeetings; i++) {
      if (socialActivityStyle.equals(OnceMonthly)) {
        int meetingDay = (int) (uniform(1, 28));
        meetingSchedule.add(meetingDay);
      } else {
        int meetingDay = randomFrom(dates);
        meetingSchedule.add(meetingDay);
        dates.remove(Integer.valueOf(meetingDay));
      }
    }
  }

  int getRandomNumberInRange(int min, int max) {
    Random r = new Random();
    return r.nextInt((max - min) + 1) + min;
  }

  void sendToInfectionGroup(String message) {
    //Main function that will infect people based on their location.
    if (inState(AtHome)) {
      infectionGroup = agentHome.members;
    } else if (inState(AtWork)) {
      infectionGroup = agentWorkplace.colleagues;
    } else if (inState(AtSchool)) {
      infectionGroup = agentSchool.classmates;
    } else if (inState(AtShoppingCentre)) {
      infectionGroup = agentMarket.shoppers;
    }
    if (infectionGroup.size() != 0) {
      if (hasMeeting) {
        for (Person p : friendContacts) {
          if (p.isAvailable) infectionGroup.add(p);
        }
      }
      send(
        message,
        infectionGroup.get(uniform_discr(0, infectionGroup.size() - 1))
      );
    } else {
      send(message, this.getNearestAgent(main.people));
    }
  }

  double calculateContactRate() {
    double rate = 0.0;
    if (agentAge < 5) {
      rate = lognormal(2.774, 0.899, 6);
    }
    if (agentAge >= 5 && agentAge < 59) {
      rate = lognormal(2.883, 0.856, 6);
    }
    if (agentAge >= 59) {
      rate = lognormal(2.599, 0.844, 5);
    }
    return rate;
  }

  double calculateCovidClinicalRate(int agentAge) {
    //Calculates Covid hospitalization rate based on age.
    double rate = 0.0;
    if (agentAge > 0 && agentAge < 10) {
      rate = 0.14;
    }
    if (agentAge >= 10 && agentAge < 20) {
      rate = 0.20;
    }
    if (agentAge >= 20 && agentAge < 30) {
      rate = 0.29;
    }
    if (agentAge >= 30 && agentAge < 40) {
      rate = 0.41;
    }
    if (agentAge >= 40 && agentAge < 50) {
      rate = 0.44;
    }
    if (agentAge >= 50 && agentAge < 60) {
      rate = 0.56;
    }
    if (agentAge >= 60 && agentAge < 70) {
      rate = 0.80;
    }
    if (agentAge >= 70) {
      rate = 0.75;
    }
    return rate;
  }

  double calculateCovidICURate(int agentAge) {
    //Calculates Covid ICU rate based on age.
    double rate = 0.0;
    if (agentAge > 0 && agentAge < 10) {
      rate = 0.01;
    }
    if (agentAge >= 10 && agentAge < 30) {
      rate = uniform(0.01, 0.05);
    }
    if (agentAge >= 30 && agentAge < 40) {
      rate = uniform(0.03, 0.05);
    }
    if (agentAge >= 40 && agentAge < 50) {
      rate = uniform(0.05, 0.10);
    }
    if (agentAge >= 50 && agentAge < 60) {
      rate = uniform(0.10, 0.20);
    }
    if (agentAge >= 60 && agentAge < 70) {
      rate = uniform(0.15, 0.20);
    }
    if (agentAge >= 70) {
      rate = uniform(0.10, 0.15);
    }
    return rate;
  }

  double calculateChronicRiskCovid() {
    //Decides the probability of a person having a condition that is a risk in the presence
    //of Covid.
    double rate = 0.0;
    if (agentAge < 18) {
      rate = 0.23;
    }
    if (agentAge >= 18 && agentAge <= 29) {
      rate = 0.20;
    }
    if (agentAge >= 30 && agentAge <= 39) {
      rate = 0.27;
    }
    if (agentAge >= 40 && agentAge <= 49) {
      rate = 0.38;
    }
    if (agentAge >= 50 && agentAge <= 59) {
      rate = 0.55;
    }
    if (agentAge >= 60 && agentAge <= 69) {
      rate = 0.68;
    }
    if (agentAge >= 70 && agentAge <= 79) {
      rate = 0.80;
    }
    if (agentAge >= 80) {
      rate = 0.81;
    }
    return rate;
  }

  double calculateChronicRiskFlu() {
    //Decides the probability of a person having a condition that is a risk in the presence
    //of flu.
    double rate = 0.0;
    if (agentAge >= 1 && agentAge <= 19) {
      rate = uniform(0.07, 0.14);
    }
    if (agentAge >= 20 && agentAge <= 29) {
      rate = 0.25;
    }
    if (agentAge >= 30 && agentAge <= 39) {
      rate = 0.22;
    }
    if (agentAge >= 40 && agentAge <= 49) {
      rate = 0.28;
    }
    if (agentAge >= 50 && agentAge <= 54) {
      rate = 0.34;
    }
    if (agentAge >= 55 && agentAge <= 59) {
      rate = 0.40;
    }
    if (agentAge >= 60 && agentAge <= 64) {
      rate = 0.48;
    }
    if (agentAge >= 65 && agentAge <= 69) {
      rate = 0.58;
    }
    if (agentAge >= 70 && agentAge <= 74) {
      rate = 0.66;
    }
    if (agentAge >= 75 && agentAge <= 79) {
      rate = 0.72;
    }
    if (agentAge >= 80 && agentAge <= 84) {
      rate = 0.78;
    }
    if (agentAge >= 85) {
      rate = 0.80;
    }
    return rate;
  }

  double calculateFluClinicalRate(int agentAge) {
    //Calculates Flu hospitalization rate based on age.
    double rate = 0.0;
    if (agentAge >= 0 && agentAge <= 4) {
      rate = 0.132;
    }
    if (agentAge >= 5 && agentAge <= 17) {
      rate = 0.079;
    }
    if (agentAge >= 18 && agentAge < 49) {
      rate = 0.074;
    }
    if (agentAge >= 50 && agentAge < 64) {
      rate = 0.120;
    }
    if (agentAge >= 65) {
      rate = 0.039;
    }
    return rate;
  }

  double calculateFluICURate(int agentAge) {
    //Calculates Flu ICU rate based on age.
    double rate = 0.0;
    if (agentAge <= 17) {
      rate = 0.07;
    }
    if (agentAge >= 18 && agentAge < 49) {
      rate = 0.49;
    }
    if (agentAge >= 50 && agentAge < 64) {
      rate = 0.32;
    }
    if (agentAge >= 65) {
      rate = 0.109;
    }
    return rate;
  }

  double calculateFluMortalityRate(int agentAge) {
    //Calculates Flu mortality rate based on age.
    double rate = 0.0;
    if (agentAge >= 0 && agentAge <= 4) {
      rate = 0.0006;
    }
    if (agentAge >= 5 && agentAge <= 17) {
      rate = 0.001;
    }
    if (agentAge >= 18 && agentAge < 49) {
      rate = 0.002;
    }
    if (agentAge >= 50 && agentAge < 64) {
      rate = 0.106;
    }
    if (agentAge >= 65) {
      rate = 0.101;
    }
    return rate;
  }

  double calculateFluDangerFactor(int agentAge) {
    //Calculates Flu risk factor based on age and health conditions.
    double factor = 1;
    if (atRiskFromFlu) {
      if (agentAge <= 1) {
        factor = 35.1;
      }
      if (agentAge >= 2 && agentAge <= 14) {
        factor = 22;
      }
      if (agentAge >= 15 && agentAge <= 44) {
        factor = 18;
      }
      if (agentAge >= 45 && agentAge <= 64) {
        factor = 5.9;
      }
      if (agentAge >= 65) {
        factor = 1.03;
      }
    }
    return factor;
  }

  double calculateCovidDangerFactor(int agentAge) {
    //Calculates Covid risk factor based on health conditions.

    double factor = 1;
    if (atRiskFromCovid) {
      factor = uniform(1.15, 2.77);
    }
    return factor;
  }

  double calculateCovidMortalityRate(int agentAge) {
    //Calculates Covid mortality rate based on age.
    double rate = 0.0;
    if (agentAge >= 1 && agentAge <= 29) {
      rate = 0.003;
    }
    if (agentAge >= 30 && agentAge <= 39) {
      rate = 0.005;
    }
    if (agentAge >= 40 && agentAge < 49) {
      rate = 0.011;
    }
    if (agentAge >= 50 && agentAge < 59) {
      rate = 0.03;
    }
    if (agentAge >= 60 && agentAge <= 69) {
      rate = 0.095;
    }
    if (agentAge >= 70 && agentAge <= 79) {
      rate = 0.22;
    }
    if (agentAge >= 80) {
      rate = 0.29;
    }
    return rate;
  }

  // View areas
  public ViewArea _origin_VA = new ViewArea(
    this,
    "[Origin]",
    0,
    0,
    ViewArea.TOP_LEFT,
    ViewArea.SPECIFIED_ZOOM,
    1,
    100,
    100
  );

  @Override
  @AnyLogicInternalCodegenAPI
  public int getViewAreas(Map<String, ViewArea> _output) {
    if (_output != null) {
      _output.put("_origin_VA", this._origin_VA);
    }
    return 1 + super.getViewAreas(_output);
  }

  @AnyLogicInternalCodegenAPI
  protected static final int _oval = 1;

  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final int _SHAPE_NEXT_ID_xjal = 2;

  /**
   * Top-level presentation group id
   */
  @AnyLogicInternalCodegenAPI
  protected static final int _presentation = 0;

  @AnyLogicInternalCodegenAPI
  public boolean isPublicPresentationDefined() {
    return true;
  }

  /**
   * Top-level icon group id
   */
  @AnyLogicInternalCodegenAPI
  protected static final int _icon = -1;

  ShapeOval oval;

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBP0_xjal() {
    oval =
      new ShapeOval(
        SHAPE_DRAW_2D3D,
        true,
        0.0,
        0.0,
        0.0,
        0.0,
        black,
        yellow,
        2.0,
        2.0,
        10.0,
        1.0,
        LINE_STYLE_SOLID
      );
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsAP0_xjal() {}

  // Static initialization of persistent elements
  {
    _createPersistentElementsBP0_xjal();
  }

  ShapeTopLevelPresentationGroup presentation;
  ShapeGroup icon;

  @Override
  @AnyLogicInternalCodegenAPI
  public Object getPersistentShape(int _shape) {
    switch (_shape) {
      case _presentation:
        return presentation;
      case _icon:
        return icon;
      case _oval:
        return oval;
      default:
        return super.getPersistentShape(_shape);
    }
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public String getNameOfShape_xjal(Object _shape) {
    try {
      if (_shape == null) return null;
      String _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, presentation, "presentation");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, icon, "icon");
      if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal(_shape, oval, "oval");
      if (_name_xjal != null) return _name_xjal;
    } catch (Exception e) {
      return null;
    }
    return super.getNameOfShape_xjal(_shape);
  }

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition16_pointsX_xjal = { 1050, 1050 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition16_pointsY_xjal = { 90, 130 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition18_pointsX_xjal = { 1050, 1050 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition18_pointsY_xjal = { 160, 200 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition48_pointsX_xjal = { 1080, 1108 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition48_pointsY_xjal = { 230, 200 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition19_pointsX_xjal = { 1050, 1040 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition19_pointsY_xjal = { 230, 270 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition22_pointsX_xjal = { 1028, 990 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition22_pointsY_xjal = { 280, 330 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition_pointsX_xjal = { 980, 980 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition_pointsY_xjal = { 360, 400 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition1_pointsX_xjal = { 980, 980 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition1_pointsY_xjal = { 420, 450 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition3_pointsX_xjal = { 960, 960 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition3_pointsY_xjal = { 480, 620 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition21_pointsX_xjal = { 972, 1090 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition21_pointsY_xjal = { 630, 630 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition23_pointsX_xjal = { 960, 960 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition23_pointsY_xjal = { 640, 732 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition53_pointsX_xjal = { 980, 1020 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition53_pointsY_xjal = { 480, 460 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition2_pointsX_xjal = { 992, 1140, 1139 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition2_pointsY_xjal = { 410, 410, 620 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition49_pointsX_xjal = { 990, 1020 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition49_pointsY_xjal = { 360, 340 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition47_pointsX_xjal = { 1052, 1188 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition47_pointsY_xjal = { 280, 280 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition10_pointsX_xjal = { 1200, 1130 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition10_pointsY_xjal = { 290, 360 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition57_pointsX_xjal = { 1160, 1163 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition57_pointsY_xjal = { 390, 620 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition35_pointsX_xjal = { 1180, 1210 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition35_pointsY_xjal = { 390, 370 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition11_pointsX_xjal = { 1200, 1250 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition11_pointsY_xjal = { 290, 360 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition59_pointsX_xjal = { 1230, 1180 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition59_pointsY_xjal = { 390, 620 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition43_pointsX_xjal = { 1280, 1320 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition43_pointsY_xjal = { 390, 370 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition24_pointsX_xjal = { 1790, 1784 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition24_pointsY_xjal = { 100, 140 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition26_pointsX_xjal = { 1790, 1790 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition26_pointsY_xjal = { 170, 210 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition25_pointsX_xjal = { 1820, 1850 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition25_pointsY_xjal = { 240, 210 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition58_pointsX_xjal = { 1790, 1770 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition58_pointsY_xjal = { 240, 270 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition32_pointsX_xjal = { 1782, 1928 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition32_pointsY_xjal = { 280, 280 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition12_pointsX_xjal = { 1940, 1940 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition12_pointsY_xjal = { 290, 320 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition27_pointsX_xjal = { 2040, 2050 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition27_pointsY_xjal = { 320, 360 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition34_pointsX_xjal = {
    1930,
    1924,
    2134,
    2140,
  };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition34_pointsY_xjal = {
    360,
    610,
    610,
    110,
  };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition30_pointsX_xjal = { 2080, 1860 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition30_pointsY_xjal = { 90, 90 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition13_pointsX_xjal = { 1952, 2010 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition13_pointsY_xjal = { 280, 280 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition60_pointsX_xjal = {
    2080,
    2080,
    2170,
    2170,
  };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition60_pointsY_xjal = {
    310,
    330,
    330,
    110,
  };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition61_pointsX_xjal = { 2100, 2120 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition61_pointsY_xjal = { 270, 310 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition33_pointsX_xjal = { 1758, 1700 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition33_pointsY_xjal = { 280, 280 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition36_pointsX_xjal = { 1636, 1630 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition36_pointsY_xjal = { 290, 330 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition37_pointsX_xjal = { 1630, 1630 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition37_pointsY_xjal = { 350, 380 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition39_pointsX_xjal = { 1650, 1650 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition39_pointsY_xjal = { 410, 450 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition38_pointsX_xjal = { 1650, 1654 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition38_pointsY_xjal = { 470, 500 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition29_pointsX_xjal = { 1659, 1660 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition29_pointsY_xjal = { 530, 600 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition31_pointsX_xjal = { 1660, 1660 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition31_pointsY_xjal = { 620, 712 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition42_pointsX_xjal = {
    1672,
    1820,
    1820,
    1880,
  };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition42_pointsY_xjal = {
    610,
    610,
    330,
    330,
  };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition41_pointsX_xjal = {
    1662,
    1820,
    1820,
    1880,
  };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition41_pointsY_xjal = {
    460,
    460,
    330,
    330,
  };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition28_pointsX_xjal = {
    1642,
    1820,
    1820,
    1880,
  };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition28_pointsY_xjal = {
    340,
    340,
    330,
    330,
  };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition40_pointsX_xjal = { 1670, 1700 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition40_pointsY_xjal = { 290, 270 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition54_pointsX_xjal = { 255, 245 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition54_pointsY_xjal = { 120, 180 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition44_pointsX_xjal = { 245, 222 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition44_pointsY_xjal = { 200, 320 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition45_pointsX_xjal = { 273, 270 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition45_pointsY_xjal = { 320, 120 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition5_pointsX_xjal = { 230, 340 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition5_pointsY_xjal = { 350, 390 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition55_pointsX_xjal = { 426, 270 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition55_pointsY_xjal = { 380, 120 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition7_pointsX_xjal = { 350, 127 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition7_pointsY_xjal = { 380, 370 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition50_pointsX_xjal = { 80, 206 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition50_pointsY_xjal = { 340, 110 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition4_pointsX_xjal = { 94, 340 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition4_pointsY_xjal = { 370, 390 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition8_pointsX_xjal = { 359, 287 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition8_pointsY_xjal = { 380, 350 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition9_pointsX_xjal = { 390, 270 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition9_pointsY_xjal = { 380, 120 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition51_pointsX_xjal = { 245, 110 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition51_pointsY_xjal = { 200, 340 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition52_pointsX_xjal = { 245, 375 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition52_pointsY_xjal = { 200, 380 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition46_pointsX_xjal = { 280, 548 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition46_pointsY_xjal = { 120, 340 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition56_pointsX_xjal = { 580, 293 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition56_pointsY_xjal = { 340, 120 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition6_pointsX_xjal = { 280, 450 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition6_pointsY_xjal = { 120, 380 };

  @AnyLogicInternalCodegenAPI
  private void drawModelElements_Events_xjal(
    Panel _panel,
    Graphics2D _g,
    boolean _publicOnly,
    boolean _isSuperClass
  ) {
    if (!_publicOnly) {
      drawEvent(
        _panel,
        _g,
        -670,
        -100,
        10,
        0,
        "update_schedule",
        update_schedule
      );
    }
    if (!_publicOnly) {
      drawEvent(_panel, _g, -670, -60, 10, 0, "has_meeting", has_meeting);
    }
    if (!_publicOnly) {
      drawEvent(_panel, _g, 509, 70, 10, 0, "morning", morning);
    }
    if (!_publicOnly) {
      drawEvent(_panel, _g, 510, 100, 10, 0, "endOfWorkDay", endOfWorkDay);
    }
    if (!_publicOnly) {
      drawEvent(_panel, _g, 510, 150, 10, 0, "meetingOver", meetingOver);
    }
    if (!_publicOnly) {
      drawEvent(_panel, _g, 511, 180, 10, 0, "meeting", meeting);
    }
  }

  @AnyLogicInternalCodegenAPI
  private void drawModelElements_Statecharts_xjal(
    Panel _panel,
    Graphics2D _g,
    boolean _publicOnly,
    boolean _isSuperClass
  ) {
    if (!_publicOnly) {
      drawState(
        _panel,
        _g,
        980,
        60,
        130,
        30,
        10,
        10,
        "Susceptible_Flu",
        GOLD,
        Susceptible_Flu,
        flu_progression
      );
    }
    if (!_publicOnly) {
      drawState(
        _panel,
        _g,
        970,
        130,
        150,
        30,
        10,
        10,
        "Exposed_Flu",
        GOLD,
        Exposed_Flu,
        flu_progression
      );
    }
    if (!_publicOnly) {
      drawState(
        _panel,
        _g,
        1090,
        620,
        100,
        30,
        10,
        10,
        "Recovered_Flu",
        gold,
        Recovered_Flu,
        flu_progression
      );
    }
    if (!_publicOnly) {
      drawBranchState(_panel, _g, 960, 630, 10, 0, null, branch5);
    }
    if (!_publicOnly) {
      drawFinalState(
        _panel,
        _g,
        960,
        740,
        10,
        0,
        "finalState_Flu",
        finalState_Flu,
        flu_progression
      );
    }
    if (!_publicOnly) {
      drawState(
        _panel,
        _g,
        920,
        330,
        100,
        30,
        10,
        10,
        "Clinical_Flu",
        GOLD,
        Clinical_Flu,
        flu_progression
      );
    }
    if (!_publicOnly) {
      drawState(
        _panel,
        _g,
        1060,
        360,
        150,
        30,
        10,
        15,
        "Asymptomatic_Flu",
        GOLD,
        Asymptomatic_Flu,
        flu_progression
      );
    }
    if (!_publicOnly) {
      drawBranchState(_panel, _g, 1040, 280, 10, 0, null, branch12);
    }
    if (!_publicOnly) {
      drawState(
        _panel,
        _g,
        920,
        450,
        100,
        30,
        10,
        10,
        "ICUFlu",
        GOLD,
        ICUFlu,
        flu_progression
      );
    }
    if (!_publicOnly) {
      drawBranchState(_panel, _g, 980, 410, 10, 0, null, branch);
    }
    if (!_publicOnly) {
      drawState(
        _panel,
        _g,
        970,
        200,
        150,
        30,
        15,
        10,
        "Infectious_Flu",
        GOLD,
        Infectious_Flu,
        flu_progression
      );
    }
    if (!_publicOnly) {
      drawBranchState(_panel, _g, 1200, 280, 10, 0, null, branch1);
    }
    if (!_publicOnly) {
      drawState(
        _panel,
        _g,
        1220,
        360,
        100,
        30,
        10,
        10,
        "Mild_Flu",
        GOLD,
        Mild_Flu,
        flu_progression
      );
    }
    if (!_publicOnly) {
      drawStatechartEntryPoint(
        _panel,
        _g,
        1030,
        20,
        1030,
        60,
        1040,
        20,
        "flu_progression",
        flu_progression
      );
    }
    if (!_publicOnly) {
      drawTransition(
        _panel,
        _g,
        _transition16_pointsX_xjal,
        _transition16_pointsY_xjal,
        1060,
        90,
        null,
        transition16,
        TransitionIcon.MESSAGE
      );
    }
    if (!_publicOnly) {
      drawTransition(
        _panel,
        _g,
        _transition18_pointsX_xjal,
        _transition18_pointsY_xjal,
        1060,
        160,
        null,
        transition18,
        TransitionIcon.TIMEOUT
      );
    }
    if (!_publicOnly) {
      drawBranchExit(
        _panel,
        _g,
        _transition21_pointsX_xjal,
        _transition21_pointsY_xjal,
        982,
        630,
        null
      );
    }
    if (!_publicOnly) {
      drawBranchExit(
        _panel,
        _g,
        _transition23_pointsX_xjal,
        _transition23_pointsY_xjal,
        970,
        640,
        null
      );
    }
    if (!_publicOnly) {
      drawBranchExit(
        _panel,
        _g,
        _transition22_pointsX_xjal,
        _transition22_pointsY_xjal,
        1038,
        280,
        null
      );
    }
    if (!_publicOnly) {
      drawBranchExit(
        _panel,
        _g,
        _transition47_pointsX_xjal,
        _transition47_pointsY_xjal,
        1062,
        280,
        null
      );
    }
    if (!_publicOnly) {
      drawTransition(
        _panel,
        _g,
        _transition57_pointsX_xjal,
        _transition57_pointsY_xjal,
        1170,
        390,
        null,
        transition57,
        TransitionIcon.TIMEOUT
      );
    }
    if (!_publicOnly) {
      drawTransition(
        _panel,
        _g,
        _transition35_pointsX_xjal,
        _transition35_pointsY_xjal,
        1190,
        390,
        null,
        transition35,
        TransitionIcon.RATE
      );
    }
    if (!_publicOnly) {
      drawTransition(
        _panel,
        _g,
        _transition_pointsX_xjal,
        _transition_pointsY_xjal,
        990,
        360,
        null,
        transition,
        TransitionIcon.TIMEOUT
      );
    }
    if (!_publicOnly) {
      drawBranchExit(
        _panel,
        _g,
        _transition1_pointsX_xjal,
        _transition1_pointsY_xjal,
        990,
        420,
        null
      );
    }
    if (!_publicOnly) {
      drawBranchExit(
        _panel,
        _g,
        _transition2_pointsX_xjal,
        _transition2_pointsY_xjal,
        1002,
        410,
        null
      );
    }
    if (!_publicOnly) {
      drawTransition(
        _panel,
        _g,
        _transition3_pointsX_xjal,
        _transition3_pointsY_xjal,
        970,
        480,
        null,
        transition3,
        TransitionIcon.TIMEOUT
      );
    }
    if (!_publicOnly) {
      drawTransition(
        _panel,
        _g,
        _transition48_pointsX_xjal,
        _transition48_pointsY_xjal,
        1090,
        230,
        null,
        transition48,
        TransitionIcon.RATE
      );
    }
    if (!_publicOnly) {
      drawTransition(
        _panel,
        _g,
        _transition49_pointsX_xjal,
        _transition49_pointsY_xjal,
        1000,
        360,
        null,
        transition49,
        TransitionIcon.RATE
      );
    }
    if (!_publicOnly) {
      drawTransition(
        _panel,
        _g,
        _transition53_pointsX_xjal,
        _transition53_pointsY_xjal,
        990,
        480,
        null,
        transition53,
        TransitionIcon.RATE
      );
    }
    if (!_publicOnly) {
      drawTransition(
        _panel,
        _g,
        _transition19_pointsX_xjal,
        _transition19_pointsY_xjal,
        1060,
        230,
        null,
        transition19,
        TransitionIcon.TIMEOUT
      );
    }
    if (!_publicOnly) {
      drawBranchExit(
        _panel,
        _g,
        _transition10_pointsX_xjal,
        _transition10_pointsY_xjal,
        1210,
        290,
        null
      );
    }
    if (!_publicOnly) {
      drawBranchExit(
        _panel,
        _g,
        _transition11_pointsX_xjal,
        _transition11_pointsY_xjal,
        1210,
        290,
        null
      );
    }
    if (!_publicOnly) {
      drawTransition(
        _panel,
        _g,
        _transition59_pointsX_xjal,
        _transition59_pointsY_xjal,
        1240,
        390,
        null,
        transition59,
        TransitionIcon.TIMEOUT
      );
    }
    if (!_publicOnly) {
      drawTransition(
        _panel,
        _g,
        _transition43_pointsX_xjal,
        _transition43_pointsY_xjal,
        1290,
        390,
        null,
        transition43,
        TransitionIcon.RATE
      );
    }
    if (!_publicOnly) {
      drawState(
        _panel,
        _g,
        1720,
        70,
        140,
        30,
        10,
        10,
        "Susceptible_Covid",
        GOLD,
        Susceptible_Covid,
        covid_progression
      );
    }
    if (!_publicOnly) {
      drawState(
        _panel,
        _g,
        1720,
        140,
        150,
        30,
        10,
        10,
        "Exposed_Covid",
        GOLD,
        Exposed_Covid,
        covid_progression
      );
    }
    if (!_publicOnly) {
      drawState(
        _panel,
        _g,
        2080,
        80,
        140,
        30,
        10,
        10,
        "Recovered_Covid",
        GOLD,
        Recovered_Covid,
        covid_progression
      );
    }
    if (!_publicOnly) {
      drawBranchState(_panel, _g, 1660, 610, 10, 0, null, branch6);
    }
    if (!_publicOnly) {
      drawFinalState(
        _panel,
        _g,
        1660,
        720,
        10,
        0,
        "finalState_Covid",
        finalState_Covid,
        covid_progression
      );
    }
    if (!_publicOnly) {
      drawBranchState(_panel, _g, 1770, 280, 10, 0, null, branch7);
    }
    if (!_publicOnly) {
      drawState(
        _panel,
        _g,
        1880,
        320,
        190,
        40,
        15,
        10,
        "Asymptomatic_Covid",
        GOLD,
        Asymptomatic_Covid,
        covid_progression
      );
    }
    if (!_publicOnly) {
      drawState(
        _panel,
        _g,
        1590,
        260,
        110,
        30,
        10,
        10,
        "Clinical_Covid",
        GOLD,
        Clinical_Covid,
        covid_progression
      );
    }
    if (!_publicOnly) {
      drawState(
        _panel,
        _g,
        1600,
        380,
        100,
        30,
        10,
        10,
        "ICU",
        GOLD,
        ICU,
        covid_progression
      );
    }
    if (!_publicOnly) {
      drawState(
        _panel,
        _g,
        1610,
        500,
        100,
        30,
        10,
        10,
        "Ventilator",
        GOLD,
        Ventilator,
        covid_progression
      );
    }
    if (!_publicOnly) {
      drawBranchState(_panel, _g, 1630, 340, 10, 0, null, branch8);
    }
    if (!_publicOnly) {
      drawBranchState(_panel, _g, 1650, 460, 10, 0, null, branch9);
    }
    if (!_publicOnly) {
      drawState(
        _panel,
        _g,
        1710,
        210,
        150,
        30,
        10,
        10,
        "Infectious_Covid",
        GOLD,
        Infectious_Covid,
        covid_progression
      );
    }
    if (!_publicOnly) {
      drawState(
        _panel,
        _g,
        2010,
        270,
        120,
        40,
        10,
        10,
        "Mild_Covid",
        GOLD,
        Mild_Covid,
        covid_progression
      );
    }
    if (!_publicOnly) {
      drawBranchState(_panel, _g, 1940, 280, 10, 0, null, branch2);
    }
    if (!_publicOnly) {
      drawStatechartEntryPoint(
        _panel,
        _g,
        1770,
        30,
        1770,
        70,
        1780,
        30,
        "covid_progression",
        covid_progression
      );
    }
    if (!_publicOnly) {
      drawTransition(
        _panel,
        _g,
        _transition24_pointsX_xjal,
        _transition24_pointsY_xjal,
        1800,
        100,
        null,
        transition24,
        TransitionIcon.MESSAGE
      );
    }
    if (!_publicOnly) {
      drawTransition(
        _panel,
        _g,
        _transition25_pointsX_xjal,
        _transition25_pointsY_xjal,
        1830,
        240,
        null,
        transition25,
        TransitionIcon.RATE
      );
    }
    if (!_publicOnly) {
      drawTransition(
        _panel,
        _g,
        _transition26_pointsX_xjal,
        _transition26_pointsY_xjal,
        1800,
        170,
        null,
        transition26,
        TransitionIcon.TIMEOUT
      );
    }
    if (!_publicOnly) {
      drawTransition(
        _panel,
        _g,
        _transition27_pointsX_xjal,
        _transition27_pointsY_xjal,
        2050,
        320,
        null,
        transition27,
        TransitionIcon.RATE
      );
    }
    if (!_publicOnly) {
      drawTransition(
        _panel,
        _g,
        _transition30_pointsX_xjal,
        _transition30_pointsY_xjal,
        2090,
        90,
        null,
        transition30,
        TransitionIcon.TIMEOUT
      );
    }
    if (!_publicOnly) {
      drawBranchExit(
        _panel,
        _g,
        _transition31_pointsX_xjal,
        _transition31_pointsY_xjal,
        1670,
        620,
        null
      );
    }
    if (!_publicOnly) {
      drawBranchExit(
        _panel,
        _g,
        _transition32_pointsX_xjal,
        _transition32_pointsY_xjal,
        1792,
        280,
        null
      );
    }
    if (!_publicOnly) {
      drawBranchExit(
        _panel,
        _g,
        _transition33_pointsX_xjal,
        _transition33_pointsY_xjal,
        1768,
        280,
        null
      );
    }
    if (!_publicOnly) {
      drawTransition(
        _panel,
        _g,
        _transition34_pointsX_xjal,
        _transition34_pointsY_xjal,
        1940,
        360,
        null,
        transition34,
        TransitionIcon.TIMEOUT
      );
    }
    if (!_publicOnly) {
      drawTransition(
        _panel,
        _g,
        _transition36_pointsX_xjal,
        _transition36_pointsY_xjal,
        1646,
        290,
        null,
        transition36,
        TransitionIcon.TIMEOUT
      );
    }
    if (!_publicOnly) {
      drawBranchExit(
        _panel,
        _g,
        _transition37_pointsX_xjal,
        _transition37_pointsY_xjal,
        1640,
        350,
        null
      );
    }
    if (!_publicOnly) {
      drawTransition(
        _panel,
        _g,
        _transition39_pointsX_xjal,
        _transition39_pointsY_xjal,
        1660,
        410,
        null,
        transition39,
        TransitionIcon.TIMEOUT
      );
    }
    if (!_publicOnly) {
      drawBranchExit(
        _panel,
        _g,
        _transition28_pointsX_xjal,
        _transition28_pointsY_xjal,
        1652,
        340,
        null
      );
    }
    if (!_publicOnly) {
      drawBranchExit(
        _panel,
        _g,
        _transition38_pointsX_xjal,
        _transition38_pointsY_xjal,
        1660,
        470,
        null
      );
    }
    if (!_publicOnly) {
      drawBranchExit(
        _panel,
        _g,
        _transition41_pointsX_xjal,
        _transition41_pointsY_xjal,
        1672,
        460,
        null
      );
    }
    if (!_publicOnly) {
      drawTransition(
        _panel,
        _g,
        _transition29_pointsX_xjal,
        _transition29_pointsY_xjal,
        1669,
        530,
        null,
        transition29,
        TransitionIcon.TIMEOUT
      );
    }
    if (!_publicOnly) {
      drawBranchExit(
        _panel,
        _g,
        _transition42_pointsX_xjal,
        _transition42_pointsY_xjal,
        1682,
        610,
        null
      );
    }
    if (!_publicOnly) {
      drawTransition(
        _panel,
        _g,
        _transition58_pointsX_xjal,
        _transition58_pointsY_xjal,
        1800,
        240,
        null,
        transition58,
        TransitionIcon.TIMEOUT
      );
    }
    if (!_publicOnly) {
      drawBranchExit(
        _panel,
        _g,
        _transition12_pointsX_xjal,
        _transition12_pointsY_xjal,
        1950,
        290,
        null
      );
    }
    if (!_publicOnly) {
      drawBranchExit(
        _panel,
        _g,
        _transition13_pointsX_xjal,
        _transition13_pointsY_xjal,
        1962,
        280,
        null
      );
    }
    if (!_publicOnly) {
      drawTransition(
        _panel,
        _g,
        _transition60_pointsX_xjal,
        _transition60_pointsY_xjal,
        2090,
        310,
        null,
        transition60,
        TransitionIcon.TIMEOUT
      );
    }
    if (!_publicOnly) {
      drawTransition(
        _panel,
        _g,
        _transition61_pointsX_xjal,
        _transition61_pointsY_xjal,
        2110,
        270,
        null,
        transition61,
        TransitionIcon.RATE
      );
    }
    if (!_publicOnly) {
      drawTransition(
        _panel,
        _g,
        _transition40_pointsX_xjal,
        _transition40_pointsY_xjal,
        1680,
        290,
        null,
        transition40,
        TransitionIcon.RATE
      );
    }
    if (!_publicOnly) {
      drawState(
        _panel,
        _g,
        206,
        90,
        98,
        30,
        10,
        10,
        "AtHome",
        GOLD,
        AtHome,
        location
      );
    }
    if (!_publicOnly) {
      drawState(
        _panel,
        _g,
        200,
        320,
        98,
        30,
        10,
        10,
        "AtWork",
        GOLD,
        AtWork,
        location
      );
    }
    if (!_publicOnly) {
      drawState(
        _panel,
        _g,
        40,
        340,
        98,
        30,
        10,
        10,
        "AtSchool",
        GOLD,
        AtSchool,
        location
      );
    }
    if (!_publicOnly) {
      drawState(
        _panel,
        _g,
        340,
        380,
        137,
        30,
        10,
        10,
        "AtShoppingCentre",
        GOLD,
        AtShoppingCentre,
        location
      );
    }
    if (!_publicOnly) {
      drawBranchState(_panel, _g, 245, 190, 10, 0, null, branch11);
    }
    if (!_publicOnly) {
      drawState(
        _panel,
        _g,
        510,
        340,
        100,
        30,
        10,
        10,
        "Hospital",
        GOLD,
        Hospital,
        location
      );
    }
    if (!_publicOnly) {
      drawStatechartEntryPoint(
        _panel,
        _g,
        255,
        60,
        255,
        90,
        265,
        60,
        "location",
        location
      );
    }
    if (!_publicOnly) {
      drawBranchExit(
        _panel,
        _g,
        _transition44_pointsX_xjal,
        _transition44_pointsY_xjal,
        255,
        200,
        null
      );
    }
    if (!_publicOnly) {
      drawTransition(
        _panel,
        _g,
        _transition45_pointsX_xjal,
        _transition45_pointsY_xjal,
        283,
        320,
        null,
        transition45,
        TransitionIcon.MESSAGE
      );
    }
    if (!_publicOnly) {
      drawTransition(
        _panel,
        _g,
        _transition50_pointsX_xjal,
        _transition50_pointsY_xjal,
        90,
        340,
        null,
        transition50,
        TransitionIcon.MESSAGE
      );
    }
    if (!_publicOnly) {
      drawBranchExit(
        _panel,
        _g,
        _transition51_pointsX_xjal,
        _transition51_pointsY_xjal,
        255,
        200,
        null
      );
    }
    if (!_publicOnly) {
      drawBranchExit(
        _panel,
        _g,
        _transition52_pointsX_xjal,
        _transition52_pointsY_xjal,
        255,
        200,
        null
      );
    }
    if (!_publicOnly) {
      drawTransition(
        _panel,
        _g,
        _transition55_pointsX_xjal,
        _transition55_pointsY_xjal,
        436,
        380,
        null,
        transition55,
        TransitionIcon.MESSAGE
      );
    }
    if (!_publicOnly) {
      drawTransition(
        _panel,
        _g,
        _transition54_pointsX_xjal,
        _transition54_pointsY_xjal,
        265,
        120,
        null,
        transition54,
        TransitionIcon.MESSAGE
      );
    }
    if (!_publicOnly) {
      drawTransition(
        _panel,
        _g,
        _transition46_pointsX_xjal,
        _transition46_pointsY_xjal,
        290,
        120,
        null,
        transition46,
        TransitionIcon.MESSAGE
      );
    }
    if (!_publicOnly) {
      drawTransition(
        _panel,
        _g,
        _transition56_pointsX_xjal,
        _transition56_pointsY_xjal,
        590,
        340,
        null,
        transition56,
        TransitionIcon.MESSAGE
      );
    }
    if (!_publicOnly) {
      drawTransition(
        _panel,
        _g,
        _transition4_pointsX_xjal,
        _transition4_pointsY_xjal,
        104,
        370,
        null,
        transition4,
        TransitionIcon.MESSAGE
      );
    }
    if (!_publicOnly) {
      drawTransition(
        _panel,
        _g,
        _transition5_pointsX_xjal,
        _transition5_pointsY_xjal,
        240,
        350,
        null,
        transition5,
        TransitionIcon.MESSAGE
      );
    }
    if (!_publicOnly) {
      drawTransition(
        _panel,
        _g,
        _transition6_pointsX_xjal,
        _transition6_pointsY_xjal,
        290,
        120,
        null,
        transition6,
        TransitionIcon.MESSAGE
      );
    }
    if (!_publicOnly) {
      drawTransition(
        _panel,
        _g,
        _transition7_pointsX_xjal,
        _transition7_pointsY_xjal,
        360,
        380,
        null,
        transition7,
        TransitionIcon.MESSAGE
      );
    }
    if (!_publicOnly) {
      drawTransition(
        _panel,
        _g,
        _transition8_pointsX_xjal,
        _transition8_pointsY_xjal,
        369,
        380,
        null,
        transition8,
        TransitionIcon.MESSAGE
      );
    }
    if (!_publicOnly) {
      drawTransition(
        _panel,
        _g,
        _transition9_pointsX_xjal,
        _transition9_pointsY_xjal,
        400,
        380,
        null,
        transition9,
        TransitionIcon.MESSAGE
      );
    }
  }

  @AnyLogicInternalCodegenAPI
  private void drawModelElements_Parameters_xjal(
    Panel _panel,
    Graphics2D _g,
    boolean _publicOnly,
    boolean _isSuperClass
  ) {
    if (!_publicOnly) {
      drawParameter(_panel, _g, -180, 40, 10, 0, "agentHome", agentHome, 0);
    }
    if (!_publicOnly) {
      drawParameter(_panel, _g, -180, 70, 10, 0, "agentSchool", agentSchool, 0);
    }
    if (!_publicOnly) {
      drawParameter(
        _panel,
        _g,
        -180,
        100,
        10,
        0,
        "agentWorkplace",
        agentWorkplace,
        0
      );
    }
    if (!_publicOnly) {
      drawParameter(_panel, _g, -180, 120, 10, 0, "agentAge", agentAge, 0);
    }
    if (!_publicOnly) {
      drawParameter(
        _panel,
        _g,
        -180,
        160,
        10,
        0,
        "socialActivityStyle",
        socialActivityStyle,
        0
      );
    }
    if (!_publicOnly) {
      drawParameter(
        _panel,
        _g,
        -180,
        190,
        10,
        0,
        "isAvailable",
        isAvailable,
        0
      );
    }
    if (!_publicOnly) {
      drawParameter(_panel, _g, -180, 220, 10, 0, "numFriends", numFriends, 0);
    }
    if (!_publicOnly) {
      drawParameter(
        _panel,
        _g,
        -190,
        250,
        10,
        0,
        "covidInfectionProbability",
        covidInfectionProbability,
        0
      );
    }
    if (!_publicOnly) {
      drawParameter(
        _panel,
        _g,
        -190,
        320,
        10,
        0,
        "covidClinicalRate",
        covidClinicalRate,
        0
      );
    }
    if (!_publicOnly) {
      drawParameter(
        _panel,
        _g,
        -190,
        340,
        10,
        0,
        "covidICURate",
        covidICURate,
        0
      );
    }
    if (!_publicOnly) {
      drawParameter(
        _panel,
        _g,
        -190,
        280,
        10,
        0,
        "fluInfectionProbability",
        fluInfectionProbability,
        0
      );
    }
    if (!_publicOnly) {
      drawParameter(
        _panel,
        _g,
        -190,
        360,
        10,
        0,
        "atRiskFromCovid",
        atRiskFromCovid,
        0
      );
    }
    if (!_publicOnly) {
      drawParameter(
        _panel,
        _g,
        -190,
        380,
        10,
        0,
        "covidChronicRisk",
        covidChronicRisk,
        0
      );
    }
    if (!_publicOnly) {
      drawParameter(
        _panel,
        _g,
        -190,
        430,
        10,
        0,
        "fluClinicalRate",
        fluClinicalRate,
        0
      );
    }
    if (!_publicOnly) {
      drawParameter(
        _panel,
        _g,
        -190,
        450,
        10,
        0,
        "atRiskFromFlu",
        atRiskFromFlu,
        0
      );
    }
    if (!_publicOnly) {
      drawParameter(
        _panel,
        _g,
        -190,
        490,
        10,
        0,
        "fluChronicRisk",
        fluChronicRisk,
        0
      );
    }
    if (!_publicOnly) {
      drawParameter(_panel, _g, -190, 470, 10, 0, "fluICURate", fluICURate, 0);
    }
    if (!_publicOnly) {
      drawParameter(
        _panel,
        _g,
        -190,
        510,
        10,
        0,
        "fluDangerFactor",
        fluDangerFactor,
        0
      );
    }
    if (!_publicOnly) {
      drawParameter(
        _panel,
        _g,
        -190,
        400,
        10,
        0,
        "covidDangerFactor",
        covidDangerFactor,
        0
      );
    }
  }

  @AnyLogicInternalCodegenAPI
  private void drawModelElements_PlainVariables_xjal(
    Panel _panel,
    Graphics2D _g,
    boolean _publicOnly,
    boolean _isSuperClass
  ) {
    if (!_publicOnly) {
      drawPlainVariable(
        _panel,
        _g,
        -490,
        40,
        10,
        0,
        "agentMarket",
        agentMarket,
        false
      );
    }
    if (!_publicOnly) {
      drawPlainVariable(
        _panel,
        _g,
        -490,
        210,
        10,
        0,
        "nearestHospital",
        nearestHospital,
        false
      );
    }
    if (!_publicOnly) {
      drawPlainVariable(
        _panel,
        _g,
        -490,
        70,
        10,
        0,
        "numMeetings",
        numMeetings,
        false
      );
    }
    if (!_publicOnly) {
      drawPlainVariable(
        _panel,
        _g,
        -490,
        140,
        10,
        0,
        "hasMeeting",
        hasMeeting,
        false
      );
    }
    if (!_publicOnly) {
      drawPlainVariable(
        _panel,
        _g,
        -490,
        170,
        10,
        0,
        "hospitalizedFlu",
        hospitalizedFlu,
        false
      );
    }
    if (!_publicOnly) {
      drawPlainVariable(
        _panel,
        _g,
        -490,
        300,
        10,
        0,
        "contactRate",
        contactRate,
        false
      );
    }
    if (!_publicOnly) {
      drawPlainVariable(_panel, _g, -490, 270, 10, 0, "factor", factor, false);
    }
    if (!_publicOnly) {
      drawPlainVariable(
        _panel,
        _g,
        -490,
        190,
        10,
        0,
        "hospitalizedCovid",
        hospitalizedCovid,
        false
      );
    }
    if (!_publicOnly) {
      drawPlainVariable(
        _panel,
        _g,
        -490,
        240,
        10,
        0,
        "canMeet",
        canMeet,
        false
      );
    }
    if (!_publicOnly) {
      drawPlainVariable(
        _panel,
        _g,
        40,
        50,
        10,
        0,
        "maskFactor",
        maskFactor,
        false
      );
    }
  }

  @AnyLogicInternalCodegenAPI
  private void drawModelElements_CollectionVariables_xjal(
    Panel _panel,
    Graphics2D _g,
    boolean _publicOnly,
    boolean _isSuperClass
  ) {
    if (!_publicOnly) {
      drawCollection(
        _panel,
        _g,
        -330,
        250,
        10,
        0,
        "friendContacts",
        friendContacts
      );
    }
    if (!_publicOnly) {
      drawCollection(
        _panel,
        _g,
        -330,
        190,
        10,
        0,
        "infectionGroup",
        infectionGroup
      );
    }
    if (!_publicOnly) {
      drawCollection(
        _panel,
        _g,
        -330,
        220,
        10,
        0,
        "meetingSchedule",
        meetingSchedule
      );
    }
  }

  @AnyLogicInternalCodegenAPI
  private void drawModelElements_Functions_xjal(
    Panel _panel,
    Graphics2D _g,
    boolean _publicOnly,
    boolean _isSuperClass
  ) {
    if (!_publicOnly) {
      drawFunction(_panel, _g, -730, 40, 10, 0, "create_schedule");
    }
    if (!_publicOnly) {
      drawFunction(_panel, _g, -730, 80, 10, 0, "getRandomNumberInRange");
    }
    if (!_publicOnly) {
      drawFunction(_panel, _g, -730, 120, 10, 0, "sendToInfectionGroup");
    }
    if (!_publicOnly) {
      drawFunction(_panel, _g, -730, 140, 10, 0, "calculateContactRate");
    }
    if (!_publicOnly) {
      drawFunction(_panel, _g, -730, 320, 10, 0, "calculateCovidClinicalRate");
    }
    if (!_publicOnly) {
      drawFunction(_panel, _g, -730, 350, 10, 0, "calculateCovidICURate");
    }
    if (!_publicOnly) {
      drawFunction(_panel, _g, -730, 230, 10, 0, "calculateChronicRiskCovid");
    }
    if (!_publicOnly) {
      drawFunction(_panel, _g, -990, 240, 10, 0, "calculateChronicRiskFlu");
    }
    if (!_publicOnly) {
      drawFunction(_panel, _g, -990, 110, 10, 0, "calculateFluClinicalRate");
    }
    if (!_publicOnly) {
      drawFunction(_panel, _g, -990, 140, 10, 0, "calculateFluICURate");
    }
    if (!_publicOnly) {
      drawFunction(_panel, _g, -990, 280, 10, 0, "calculateFluMortalityRate");
    }
    if (!_publicOnly) {
      drawFunction(_panel, _g, -990, 210, 10, 0, "calculateFluDangerFactor");
    }
    if (!_publicOnly) {
      drawFunction(_panel, _g, -730, 260, 10, 0, "calculateCovidDangerFactor");
    }
    if (!_publicOnly) {
      drawFunction(_panel, _g, -730, 290, 10, 0, "calculateCovidMortalityRate");
    }
  }

  @AnyLogicInternalCodegenAPI
  private void drawModelElements_AgentLinks_xjal(
    Panel _panel,
    Graphics2D _g,
    boolean _publicOnly,
    boolean _isSuperClass
  ) {
    if (_publicOnly) {
      return;
    }
    drawLinkToContainer(_panel, _g, 50, -100, 10, 0, "main", main);
    drawLinkToAgent(
      _panel,
      _g,
      50,
      -50,
      15,
      0,
      "connections",
      true,
      connections
    );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void drawModelElements(
    Panel _panel,
    Graphics2D _g,
    boolean _publicOnly,
    boolean _isSuperClass
  ) {
    super.drawModelElements(_panel, _g, _publicOnly, true);
    drawModelElements_Events_xjal(_panel, _g, _publicOnly, _isSuperClass);
    drawModelElements_Statecharts_xjal(_panel, _g, _publicOnly, _isSuperClass);
    drawModelElements_Parameters_xjal(_panel, _g, _publicOnly, _isSuperClass);
    drawModelElements_PlainVariables_xjal(
      _panel,
      _g,
      _publicOnly,
      _isSuperClass
    );
    drawModelElements_CollectionVariables_xjal(
      _panel,
      _g,
      _publicOnly,
      _isSuperClass
    );
    drawModelElements_Functions_xjal(_panel, _g, _publicOnly, _isSuperClass);
    drawModelElements_AgentLinks_xjal(_panel, _g, _publicOnly, _isSuperClass);
  }

  @AnyLogicInternalCodegenAPI
  private boolean onClickModelAt_AgentLinks_xjal(
    Panel _panel,
    double _x,
    double _y,
    int _clickCount,
    boolean _publicOnly,
    boolean _isSuperClass
  ) {
    if (modelElementContains(_x, _y, 50, -100)) {
      if (_clickCount == 2) {
        _panel.browseAgent_xjal(50, -100, this, "main");
      } else {
        _panel.addInspect(50, -100, this, "main");
      }
      return true;
    }
    if (modelElementContains(_x, _y, 50, -50)) {
      _panel.addInspect_xjal(
        50,
        -50,
        this,
        "connections",
        Panel.INSPECT_CONNECTIONS_xjal
      );
      return true;
    }
    return false;
  }

  @AnyLogicInternalCodegenAPI
  private boolean onClickModelAt_Parameters_xjal(
    Panel _panel,
    double _x,
    double _y,
    int _clickCount,
    boolean _publicOnly,
    boolean _isSuperClass
  ) {
    if (!_publicOnly && modelElementContains(_x, _y, -180, 40)) {
      _panel.addInspect(-180, 40, this, "agentHome");
      return true;
    }
    if (!_publicOnly && modelElementContains(_x, _y, -180, 70)) {
      _panel.addInspect(-180, 70, this, "agentSchool");
      return true;
    }
    if (!_publicOnly && modelElementContains(_x, _y, -180, 100)) {
      _panel.addInspect(-180, 100, this, "agentWorkplace");
      return true;
    }
    if (!_publicOnly && modelElementContains(_x, _y, -180, 120)) {
      _panel.addInspect(-180, 120, this, "agentAge");
      return true;
    }
    if (!_publicOnly && modelElementContains(_x, _y, -180, 160)) {
      _panel.addInspect(-180, 160, this, "socialActivityStyle");
      return true;
    }
    if (!_publicOnly && modelElementContains(_x, _y, -180, 190)) {
      _panel.addInspect(-180, 190, this, "isAvailable");
      return true;
    }
    if (!_publicOnly && modelElementContains(_x, _y, -180, 220)) {
      _panel.addInspect(-180, 220, this, "numFriends");
      return true;
    }
    if (!_publicOnly && modelElementContains(_x, _y, -190, 250)) {
      _panel.addInspect(-190, 250, this, "covidInfectionProbability");
      return true;
    }
    if (!_publicOnly && modelElementContains(_x, _y, -190, 320)) {
      _panel.addInspect(-190, 320, this, "covidClinicalRate");
      return true;
    }
    if (!_publicOnly && modelElementContains(_x, _y, -190, 340)) {
      _panel.addInspect(-190, 340, this, "covidICURate");
      return true;
    }
    if (!_publicOnly && modelElementContains(_x, _y, -190, 280)) {
      _panel.addInspect(-190, 280, this, "fluInfectionProbability");
      return true;
    }
    if (!_publicOnly && modelElementContains(_x, _y, -190, 360)) {
      _panel.addInspect(-190, 360, this, "atRiskFromCovid");
      return true;
    }
    if (!_publicOnly && modelElementContains(_x, _y, -190, 380)) {
      _panel.addInspect(-190, 380, this, "covidChronicRisk");
      return true;
    }
    if (!_publicOnly && modelElementContains(_x, _y, -190, 430)) {
      _panel.addInspect(-190, 430, this, "fluClinicalRate");
      return true;
    }
    if (!_publicOnly && modelElementContains(_x, _y, -190, 450)) {
      _panel.addInspect(-190, 450, this, "atRiskFromFlu");
      return true;
    }
    if (!_publicOnly && modelElementContains(_x, _y, -190, 490)) {
      _panel.addInspect(-190, 490, this, "fluChronicRisk");
      return true;
    }
    if (!_publicOnly && modelElementContains(_x, _y, -190, 470)) {
      _panel.addInspect(-190, 470, this, "fluICURate");
      return true;
    }
    if (!_publicOnly && modelElementContains(_x, _y, -190, 510)) {
      _panel.addInspect(-190, 510, this, "fluDangerFactor");
      return true;
    }
    if (!_publicOnly && modelElementContains(_x, _y, -190, 400)) {
      _panel.addInspect(-190, 400, this, "covidDangerFactor");
      return true;
    }
    return false;
  }

  @AnyLogicInternalCodegenAPI
  private boolean onClickModelAt_PlainVariables_xjal(
    Panel _panel,
    double _x,
    double _y,
    int _clickCount,
    boolean _publicOnly,
    boolean _isSuperClass
  ) {
    if (!_publicOnly && modelElementContains(_x, _y, -490, 40)) {
      _panel.addInspect(-490, 40, this, "agentMarket");
      return true;
    }
    if (!_publicOnly && modelElementContains(_x, _y, -490, 210)) {
      _panel.addInspect(-490, 210, this, "nearestHospital");
      return true;
    }
    if (!_publicOnly && modelElementContains(_x, _y, -490, 70)) {
      _panel.addInspect(-490, 70, this, "numMeetings");
      return true;
    }
    if (!_publicOnly && modelElementContains(_x, _y, -490, 140)) {
      _panel.addInspect(-490, 140, this, "hasMeeting");
      return true;
    }
    if (!_publicOnly && modelElementContains(_x, _y, -490, 170)) {
      _panel.addInspect(-490, 170, this, "hospitalizedFlu");
      return true;
    }
    if (!_publicOnly && modelElementContains(_x, _y, -490, 300)) {
      _panel.addInspect(-490, 300, this, "contactRate");
      return true;
    }
    if (!_publicOnly && modelElementContains(_x, _y, -490, 270)) {
      _panel.addInspect(-490, 270, this, "factor");
      return true;
    }
    if (!_publicOnly && modelElementContains(_x, _y, -490, 190)) {
      _panel.addInspect(-490, 190, this, "hospitalizedCovid");
      return true;
    }
    if (!_publicOnly && modelElementContains(_x, _y, -490, 240)) {
      _panel.addInspect(-490, 240, this, "canMeet");
      return true;
    }
    if (!_publicOnly && modelElementContains(_x, _y, 40, 50)) {
      _panel.addInspect(40, 50, this, "maskFactor");
      return true;
    }
    return false;
  }

  @AnyLogicInternalCodegenAPI
  private boolean onClickModelAt_CollectionVariables_xjal(
    Panel _panel,
    double _x,
    double _y,
    int _clickCount,
    boolean _publicOnly,
    boolean _isSuperClass
  ) {
    if (!_publicOnly && modelElementContains(_x, _y, -330, 250)) {
      _panel.addInspect(-330, 250, this, "friendContacts");
      return true;
    }
    if (!_publicOnly && modelElementContains(_x, _y, -330, 190)) {
      _panel.addInspect(-330, 190, this, "infectionGroup");
      return true;
    }
    if (!_publicOnly && modelElementContains(_x, _y, -330, 220)) {
      _panel.addInspect(-330, 220, this, "meetingSchedule");
      return true;
    }
    return false;
  }

  @AnyLogicInternalCodegenAPI
  private boolean onClickModelAt_Events_xjal(
    Panel _panel,
    double _x,
    double _y,
    int _clickCount,
    boolean _publicOnly,
    boolean _isSuperClass
  ) {
    if (!_publicOnly && modelElementContains(_x, _y, -670, -100)) {
      _panel.addInspect(-670, -100, this, "update_schedule");
      return true;
    }
    if (!_publicOnly && modelElementContains(_x, _y, -670, -60)) {
      _panel.addInspect(-670, -60, this, "has_meeting");
      return true;
    }
    if (!_publicOnly && modelElementContains(_x, _y, 509, 70)) {
      _panel.addInspect(509, 70, this, "morning");
      return true;
    }
    if (!_publicOnly && modelElementContains(_x, _y, 510, 100)) {
      _panel.addInspect(510, 100, this, "endOfWorkDay");
      return true;
    }
    if (!_publicOnly && modelElementContains(_x, _y, 510, 150)) {
      _panel.addInspect(510, 150, this, "meetingOver");
      return true;
    }
    if (!_publicOnly && modelElementContains(_x, _y, 511, 180)) {
      _panel.addInspect(511, 180, this, "meeting");
      return true;
    }
    return false;
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public boolean onClickModelAt(
    Panel _panel,
    double _x,
    double _y,
    int _clickCount,
    boolean _publicOnly,
    boolean _isSuperClass
  ) {
    if (
      onClickModelAt_AgentLinks_xjal(
        _panel,
        _x,
        _y,
        _clickCount,
        _publicOnly,
        _isSuperClass
      )
    ) {
      return true;
    }
    if (
      onClickModelAt_Parameters_xjal(
        _panel,
        _x,
        _y,
        _clickCount,
        _publicOnly,
        _isSuperClass
      )
    ) {
      return true;
    }
    if (
      onClickModelAt_PlainVariables_xjal(
        _panel,
        _x,
        _y,
        _clickCount,
        _publicOnly,
        _isSuperClass
      )
    ) {
      return true;
    }
    if (
      onClickModelAt_CollectionVariables_xjal(
        _panel,
        _x,
        _y,
        _clickCount,
        _publicOnly,
        _isSuperClass
      )
    ) {
      return true;
    }
    if (
      onClickModelAt_Events_xjal(
        _panel,
        _x,
        _y,
        _clickCount,
        _publicOnly,
        _isSuperClass
      )
    ) {
      return true;
    }
    return super.onClickModelAt(_panel, _x, _y, _clickCount, _publicOnly, true);
  }

  /**
   * Constructor
   */
  public Person(
    Engine engine,
    Agent owner,
    AgentList<? extends Person> collection
  ) {
    super(engine, owner, collection);
    if (isTopLevelClass_xjal(Person.class)) {
      instantiateBaseStructure_xjal();
    }
  }

  @AnyLogicInternalCodegenAPI
  public void onOwnerChanged_xjal() {
    super.onOwnerChanged_xjal();
    setupReferences_xjal();
  }

  @AnyLogicInternalCodegenAPI
  public void instantiateBaseStructure_xjal() {
    super.instantiateBaseStructure_xjal();
    setupReferences_xjal();
  }

  @AnyLogicInternalCodegenAPI
  private void setupReferences_xjal() {
    main = get_Main();
  }

  /**
   * Simple constructor. Please add created agent to some population by calling goToPopulation() function
   */
  public Person() {}

  /**
   * Simple constructor. Please add created agent to some population by calling goToPopulation() function
   */
  public Person(
    Home agentHome,
    School agentSchool,
    Workplace agentWorkplace,
    int agentAge,
    SocialActivity socialActivityStyle,
    boolean isAvailable,
    int numFriends,
    double covidInfectionProbability,
    double covidClinicalRate,
    double covidICURate,
    double fluInfectionProbability,
    boolean atRiskFromCovid,
    double covidChronicRisk,
    double fluClinicalRate,
    boolean atRiskFromFlu,
    double fluChronicRisk,
    double fluICURate,
    double fluDangerFactor,
    double covidDangerFactor
  ) {
    markParametersAreSet();
    this.agentHome = agentHome;
    this.agentSchool = agentSchool;
    this.agentWorkplace = agentWorkplace;
    this.agentAge = agentAge;
    this.socialActivityStyle = socialActivityStyle;
    this.isAvailable = isAvailable;
    this.numFriends = numFriends;
    this.covidInfectionProbability = covidInfectionProbability;
    this.covidClinicalRate = covidClinicalRate;
    this.covidICURate = covidICURate;
    this.fluInfectionProbability = fluInfectionProbability;
    this.atRiskFromCovid = atRiskFromCovid;
    this.covidChronicRisk = covidChronicRisk;
    this.fluClinicalRate = fluClinicalRate;
    this.atRiskFromFlu = atRiskFromFlu;
    this.fluChronicRisk = fluChronicRisk;
    this.fluICURate = fluICURate;
    this.fluDangerFactor = fluDangerFactor;
    this.covidDangerFactor = covidDangerFactor;
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void create() {
    super.create();
    // Assigning initial values for plain variables
    setupPlainVariables_Person_xjal();
    // Dynamic initialization of persistent elements
    _createPersistentElementsAP0_xjal();
    presentation =
      new ShapeTopLevelPresentationGroup(Person.this, true, 0, 0, 0, 0, oval);
    icon = new ShapeGroup(Person.this, true, 0, 0, 0);
    // Port connectors with non-replicated objects
    // Creating replicated embedded objects
    setupInitialConditions_xjal(Person.class);
    if (isTopLevelClass_xjal(Person.class)) {
      onCreate();
    }
  }

  @AnyLogicInternalCodegenAPI
  public void setupExt_xjal(AgentExtension _ext) {
    // Agent properties setup
    if (_ext instanceof ExtAgentWithSpatialMetrics) {
      double _value = 4000;
      ((ExtAgentWithSpatialMetrics) _ext).setVelocity(_value);
    }
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void start() {
    super.start();
    update_schedule.start();
    has_meeting.start();
    morning.start();
    endOfWorkDay.start();
    meetingOver.start();
    meeting.start();
    flu_progression.start();
    covid_progression.start();
    location.start();
    if (isTopLevelClass_xjal(Person.class)) {
      onStartup();
    }
  }

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  public void setupPlainVariables_xjal() {
    setupPlainVariables_Person_xjal();
  }

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  private void setupPlainVariables_Person_xjal() {
    numMeetings = 1;
    hasMeeting = false;
    hospitalizedFlu = false;
    contactRate = calculateContactRate();
    factor = 1;
    hospitalizedCovid = false;
    canMeet = true;
    maskFactor = main.masks;
  }

  // User API -----------------------------------------------------
  public Main get_Main() {
    {
      Agent owner = getOwner();
      if (owner instanceof Main) return (Main) owner;
    }
    return null;
  }

  /**
   * Read-only variable. <em>Shouldn't be modified by user.</em>
   */
  @AnyLogicCustomSerialization(AnyLogicCustomSerializationMode.REFERENCE)
  public transient abm_multiple_disease_spread.Main main;

  @AnyLogicInternalCodegenAPI
  static LinkToAgentAnimationSettings _connections_commonAnimationSettings_xjal = new LinkToAgentAnimationSettingsImpl(
    false,
    black,
    1.0,
    LINE_STYLE_SOLID,
    ARROW_NONE,
    0.0
  );

  public LinkToAgentCollection<Agent, Agent> connections = new LinkToAgentStandardImpl<Agent, Agent>(
    this,
    _connections_commonAnimationSettings_xjal
  );

  @Override
  public LinkToAgentCollection<? extends Agent, ? extends Agent> getLinkToAgentStandard_xjal() {
    return connections;
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void onReceive(Object _msg_xjal, Agent _sender_xjal) {
    super.onReceive(_msg_xjal, _sender_xjal);
    flu_progression.fireEvent(_msg_xjal);
    covid_progression.fireEvent(_msg_xjal);
    location.fireEvent(_msg_xjal);
  }

  @AnyLogicInternalCodegenAPI
  public void drawLinksToAgents(
    boolean _underAgents_xjal,
    LinkToAgentAnimator _animator_xjal
  ) {
    super.drawLinksToAgents(_underAgents_xjal, _animator_xjal);
    if (_underAgents_xjal) {
      _animator_xjal.drawLink(this, connections, true, true);
    }
  }

  public AgentList<? extends Person> getPopulation() {
    return (AgentList<? extends Person>) super.getPopulation();
  }

  public List<? extends Person> agentsInRange(double distance) {
    return (List<? extends Person>) super.agentsInRange(distance);
  }

  // Reaction on changes -------------------------------------
  public void onChange() {
    super.onChange();
    flu_progression.onChange();
    covid_progression.onChange();
    location.onChange();
  }

  @AnyLogicInternalCodegenAPI
  public void onDestroy() {
    update_schedule.onDestroy();
    has_meeting.onDestroy();
    morning.onDestroy();
    endOfWorkDay.onDestroy();
    meetingOver.onDestroy();
    meeting.onDestroy();
    flu_progression.onDestroy();
    covid_progression.onDestroy();
    location.onDestroy();
    super.onDestroy();
  }

  /**
   * This number is here for model snapshot storing purpose. It shouldn't be modified by user.
   */
  @AnyLogicInternalCodegenAPI
  private static final long serialVersionUID = -6734944135643311458L;
}
