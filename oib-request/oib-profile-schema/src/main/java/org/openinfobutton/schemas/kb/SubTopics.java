//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.01.07 at 12:37:02 PM MST 
//


package org.openinfobutton.schemas.kb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.kscs.util.jaxb.Buildable;
import com.kscs.util.jaxb.PropertyTree;
import com.kscs.util.jaxb.PropertyTreeUse;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{}subTopic" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "subTopic"
})
@XmlRootElement(name = "subTopics")
public class SubTopics {

    @XmlElement(required = true)
    protected List<SubTopic> subTopic;

    /**
     * Gets the value of the subTopic property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the subTopic property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubTopic().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SubTopic }
     * 
     * 
     */
    public List<SubTopic> getSubTopic() {
        if (subTopic == null) {
            subTopic = new ArrayList<SubTopic>();
        }
        return this.subTopic;
    }

    /**
     * Copies all state of this object to a builder. This method is used by the {@link #copyOf} method and should not be called directly by client code.
     * 
     * @param _other
     *     A builder instance to which the state of this object will be copied.
     */
    public<_B >void copyTo(final SubTopics.Builder<_B> _other) {
        if (this.subTopic == null) {
            _other.subTopic = null;
        } else {
            _other.subTopic = new ArrayList<SubTopic.Builder<SubTopics.Builder<_B>>>();
            for (SubTopic _item: this.subTopic) {
                _other.subTopic.add(((_item == null)?null:_item.newCopyBuilder(_other)));
            }
        }
    }

    public<_B >SubTopics.Builder<_B> newCopyBuilder(final _B _parentBuilder) {
        return new SubTopics.Builder<_B>(_parentBuilder, this, true);
    }

    public SubTopics.Builder<Void> newCopyBuilder() {
        return newCopyBuilder(null);
    }

    public static SubTopics.Builder<Void> builder() {
        return new SubTopics.Builder<Void>(null, null, false);
    }

    public static<_B >SubTopics.Builder<_B> copyOf(final SubTopics _other) {
        final SubTopics.Builder<_B> _newBuilder = new SubTopics.Builder<_B>(null, null, false);
        _other.copyTo(_newBuilder);
        return _newBuilder;
    }

    /**
     * Copies all state of this object to a builder. This method is used by the {@link #copyOf} method and should not be called directly by client code.
     * 
     * @param _other
     *     A builder instance to which the state of this object will be copied.
     */
    public<_B >void copyTo(final SubTopics.Builder<_B> _other, final PropertyTree _propertyTree, final PropertyTreeUse _propertyTreeUse) {
        final PropertyTree subTopicPropertyTree = ((_propertyTree == null)?null:_propertyTree.get("subTopic"));
        if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)?(subTopicPropertyTree!= null):((subTopicPropertyTree == null)||(!subTopicPropertyTree.isLeaf())))) {
            if (this.subTopic == null) {
                _other.subTopic = null;
            } else {
                _other.subTopic = new ArrayList<SubTopic.Builder<SubTopics.Builder<_B>>>();
                for (SubTopic _item: this.subTopic) {
                    _other.subTopic.add(((_item == null)?null:_item.newCopyBuilder(_other, subTopicPropertyTree, _propertyTreeUse)));
                }
            }
        }
    }

    public<_B >SubTopics.Builder<_B> newCopyBuilder(final _B _parentBuilder, final PropertyTree _propertyTree, final PropertyTreeUse _propertyTreeUse) {
        return new SubTopics.Builder<_B>(_parentBuilder, this, true, _propertyTree, _propertyTreeUse);
    }

    public SubTopics.Builder<Void> newCopyBuilder(final PropertyTree _propertyTree, final PropertyTreeUse _propertyTreeUse) {
        return newCopyBuilder(null, _propertyTree, _propertyTreeUse);
    }

    public static<_B >SubTopics.Builder<_B> copyOf(final SubTopics _other, final PropertyTree _propertyTree, final PropertyTreeUse _propertyTreeUse) {
        final SubTopics.Builder<_B> _newBuilder = new SubTopics.Builder<_B>(null, null, false);
        _other.copyTo(_newBuilder, _propertyTree, _propertyTreeUse);
        return _newBuilder;
    }

    public static SubTopics.Builder<Void> copyExcept(final SubTopics _other, final PropertyTree _propertyTree) {
        return copyOf(_other, _propertyTree, PropertyTreeUse.EXCLUDE);
    }

    public static SubTopics.Builder<Void> copyOnly(final SubTopics _other, final PropertyTree _propertyTree) {
        return copyOf(_other, _propertyTree, PropertyTreeUse.INCLUDE);
    }

    public static class Builder<_B >implements Buildable
    {

        protected final _B _parentBuilder;
        protected final SubTopics _storedValue;
        private List<SubTopic.Builder<SubTopics.Builder<_B>>> subTopic;

        public Builder(final _B _parentBuilder, final SubTopics _other, final boolean _copy) {
            this._parentBuilder = _parentBuilder;
            if (_other!= null) {
                if (_copy) {
                    _storedValue = null;
                    if (_other.subTopic == null) {
                        this.subTopic = null;
                    } else {
                        this.subTopic = new ArrayList<SubTopic.Builder<SubTopics.Builder<_B>>>();
                        for (SubTopic _item: _other.subTopic) {
                            this.subTopic.add(((_item == null)?null:_item.newCopyBuilder(this)));
                        }
                    }
                } else {
                    _storedValue = _other;
                }
            } else {
                _storedValue = null;
            }
        }

        public Builder(final _B _parentBuilder, final SubTopics _other, final boolean _copy, final PropertyTree _propertyTree, final PropertyTreeUse _propertyTreeUse) {
            this._parentBuilder = _parentBuilder;
            if (_other!= null) {
                if (_copy) {
                    _storedValue = null;
                    final PropertyTree subTopicPropertyTree = ((_propertyTree == null)?null:_propertyTree.get("subTopic"));
                    if (((_propertyTreeUse == PropertyTreeUse.INCLUDE)?(subTopicPropertyTree!= null):((subTopicPropertyTree == null)||(!subTopicPropertyTree.isLeaf())))) {
                        if (_other.subTopic == null) {
                            this.subTopic = null;
                        } else {
                            this.subTopic = new ArrayList<SubTopic.Builder<SubTopics.Builder<_B>>>();
                            for (SubTopic _item: _other.subTopic) {
                                this.subTopic.add(((_item == null)?null:_item.newCopyBuilder(this, subTopicPropertyTree, _propertyTreeUse)));
                            }
                        }
                    }
                } else {
                    _storedValue = _other;
                }
            } else {
                _storedValue = null;
            }
        }

        public _B end() {
            return this._parentBuilder;
        }

        protected<_P extends SubTopics >_P init(final _P _product) {
            if (this.subTopic!= null) {
                final List<SubTopic> subTopic = new ArrayList<SubTopic>(this.subTopic.size());
                for (SubTopic.Builder<SubTopics.Builder<_B>> _item: this.subTopic) {
                    subTopic.add(_item.build());
                }
                _product.subTopic = subTopic;
            }
            return _product;
        }

        /**
         * Adds the given items to the value of "subTopic"
         * 
         * @param subTopic
         *     Items to add to the value of the "subTopic" property
         */
        public SubTopics.Builder<_B> addSubTopic(final Iterable<? extends SubTopic> subTopic) {
            if (subTopic!= null) {
                if (this.subTopic == null) {
                    this.subTopic = new ArrayList<SubTopic.Builder<SubTopics.Builder<_B>>>();
                }
                for (SubTopic _item: subTopic) {
                    this.subTopic.add(new SubTopic.Builder<SubTopics.Builder<_B>>(this, _item, false));
                }
            }
            return this;
        }

        /**
         * Sets the new value of "subTopic" (any previous value will be replaced)
         * 
         * @param subTopic
         *     New value of the "subTopic" property.
         */
        public SubTopics.Builder<_B> withSubTopic(final Iterable<? extends SubTopic> subTopic) {
            if (this.subTopic!= null) {
                this.subTopic.clear();
            }
            return addSubTopic(subTopic);
        }

        /**
         * Adds the given items to the value of "subTopic"
         * 
         * @param subTopic
         *     Items to add to the value of the "subTopic" property
         */
        public SubTopics.Builder<_B> addSubTopic(SubTopic... subTopic) {
            addSubTopic(Arrays.asList(subTopic));
            return this;
        }

        /**
         * Sets the new value of "subTopic" (any previous value will be replaced)
         * 
         * @param subTopic
         *     New value of the "subTopic" property.
         */
        public SubTopics.Builder<_B> withSubTopic(SubTopic... subTopic) {
            withSubTopic(Arrays.asList(subTopic));
            return this;
        }

        /**
         * Returns a new builder to build an additional value of the "SubTopic" property.
         * Use {@link org.openinfobutton.schemas.kb.SubTopic.Builder#end()} to return to the current builder.
         * 
         * @return
         *     a new builder to build an additional value of the "SubTopic" property.
         *     Use {@link org.openinfobutton.schemas.kb.SubTopic.Builder#end()} to return to the current builder.
         */
        public SubTopic.Builder<? extends SubTopics.Builder<_B>> addSubTopic() {
            if (this.subTopic == null) {
                this.subTopic = new ArrayList<SubTopic.Builder<SubTopics.Builder<_B>>>();
            }
            final SubTopic.Builder<SubTopics.Builder<_B>> subTopic_Builder = new SubTopic.Builder<SubTopics.Builder<_B>>(this, null, false);
            this.subTopic.add(subTopic_Builder);
            return subTopic_Builder;
        }

        @Override
        public SubTopics build() {
            if (_storedValue == null) {
                return this.init(new SubTopics());
            } else {
                return ((SubTopics) _storedValue);
            }
        }

    }

    public static class Select
        extends SubTopics.Selector<SubTopics.Select, Void>
    {


        Select() {
            super(null, null, null);
        }

        public static SubTopics.Select _root() {
            return new SubTopics.Select();
        }

    }

    public static class Selector<TRoot extends com.kscs.util.jaxb.Selector<TRoot, ?> , TParent >
        extends com.kscs.util.jaxb.Selector<TRoot, TParent>
    {

        private SubTopic.Selector<TRoot, SubTopics.Selector<TRoot, TParent>> subTopic = null;

        public Selector(final TRoot root, final TParent parent, final String propertyName) {
            super(root, parent, propertyName);
        }

        @Override
        public Map<String, PropertyTree> buildChildren() {
            final Map<String, PropertyTree> products = new HashMap<String, PropertyTree>();
            products.putAll(super.buildChildren());
            if (this.subTopic!= null) {
                products.put("subTopic", this.subTopic.init());
            }
            return products;
        }

        public SubTopic.Selector<TRoot, SubTopics.Selector<TRoot, TParent>> subTopic() {
            return ((this.subTopic == null)?this.subTopic = new SubTopic.Selector<TRoot, SubTopics.Selector<TRoot, TParent>>(this._root, this, "subTopic"):this.subTopic);
        }

    }

}
